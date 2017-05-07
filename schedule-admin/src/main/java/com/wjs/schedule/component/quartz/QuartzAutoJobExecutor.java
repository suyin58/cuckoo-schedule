package com.wjs.schedule.component.quartz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.wjs.schedule.component.mail.MailSendSpring;
import com.wjs.schedule.constant.CuckooJobConstant;
import com.wjs.schedule.dao.exec.CuckooJobDetailMapper;
import com.wjs.schedule.dao.exec.CuckooJobExtendMapper;
import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobDetailCriteria;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.domain.exec.CuckooJobExtend;
import com.wjs.schedule.enums.CuckooBooleanFlag;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.enums.CuckooJobStatus;
import com.wjs.schedule.enums.CuckooJobTriggerType;
import com.wjs.schedule.qry.QryBase;
import com.wjs.schedule.qry.job.JobLogQry;
import com.wjs.schedule.service.job.CuckooJobLogService;
import com.wjs.schedule.service.net.CuckooNetService;
import com.wjs.schedule.vo.job.CuckooJobExecLogVo;
import com.wjs.util.DateUtil;
import com.wjs.util.bean.PropertyUtil;
import com.wjs.util.config.ConfigUtil;
import com.wjs.util.dao.PageDataList;

@Component("quartzAutoJobExecutor")
public class QuartzAutoJobExecutor extends QuartzJobBean {


	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzAutoJobExecutor.class);

	@Autowired
	CuckooJobDetailMapper cuckooJobDetailMapper;
	
	@Autowired
	CuckooJobLogService cuckooJobLogService;
	
	@Autowired
	CuckooJobExtendMapper cuckooJobExtendMapper;
	
	@Autowired
	QuartzManage quartzManage;
	
	@Autowired
	MailSendSpring mailSendSpring;
	
	@Autowired
	CuckooNetService cuckooNetService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		 
		try {
			// 检查未初始化的Cron任务
			cronQuartzInit();
			
			// 检查PENDING任务丢失问题-- PENDING任务执行中，如果服务器重启情况
			pendingJobCronCheck();
			
			// 任务超时/失败等告警
			waringJobException();
			
			// 服务器、执行器长时间弃用校验
			removeUselessCuckooNetMessage();
			
		} catch (Exception e) {
			LOGGER.error("unknow error:{}", e.getMessage() , e);
		}
		
	}
	
	
	private void removeUselessCuckooNetMessage() {

		cuckooNetService.removeUselessCuckooNetMessage();
	}

	/**
	 * 任务超时/失败等告警
	 */
	private void waringJobException() {


		// 失败/断线列表 在修改任务状态的时候及时发出，此处不用处理
		
		// 任务超时列表 Map<mailTo,List<joblogs>>
		Map<String, Set<CuckooJobExecLogVo>> mailSends = new HashMap<>();
		
		QryBase qry = new QryBase();
		qry.setStart(0);
		qry.setLimit(1000);
		for (int i = 0; ; i++) {
			qry.setStart(i * qry.getLimit());
			PageDataList<CuckooJobExecLog> logPage = cuckooJobLogService.pageOverTimeJobs(qry);
			if(CollectionUtils.isNotEmpty(logPage.getRows())){
				for (CuckooJobExecLog log : logPage.getRows()) {
					CuckooJobExecLogVo vo = new CuckooJobExecLogVo();
					PropertyUtil.copyProperties(vo, log);
					CuckooJobExtend cuckooJobExtend = cuckooJobExtendMapper.selectByPrimaryKey(log.getJobId());
					if(null != cuckooJobExtend){
						String mailList = cuckooJobExtend.getEmailList();
						if(StringUtils.isEmpty(mailList)){
							continue;
						}
						String[] mailArr = mailList.split(",");
						for (String mailTo : mailArr) {
							if(mailSends.containsKey(mailTo)){
								mailSends.get(mailTo).add(vo);
							}else{
								
								Set<CuckooJobExecLogVo> logs = new HashSet<>();
								logs.add(vo);
								mailSends.put(mailTo, logs);
							}
						}
					}
					
				}
			}else{
				break;
			}
		}
		
		
		for (Iterator<Entry<String, Set<CuckooJobExecLogVo>>> it =  mailSends.entrySet().iterator(); it.hasNext() ;) {
			Entry<String, Set<CuckooJobExecLogVo>> entry = it.next();
			
			StringBuffer mailTitle = new StringBuffer("任务执行超时提醒");
			StringBuffer mailContent = new StringBuffer("超时任务信息列表:"+DateUtil.getStringDay(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
			
			Set<CuckooJobExecLogVo> logs = entry.getValue();
			for (Iterator<CuckooJobExecLogVo> logIt =  logs.iterator(); logIt.hasNext() ;) {

				CuckooJobExecLogVo vo = logIt.next();
//				mailTitle.append(vo.getJobName() + ",");
				
				mailContent.append("<br/>");
				mailContent.append("logId:");
				mailContent.append(vo.getId());
				mailContent.append(",jobId:");
				mailContent.append(vo.getJobId());
				mailContent.append(",jobName:");
				mailContent.append(vo.getJobName());
				mailContent.append(",jobStartTime:");
				mailContent.append(vo.getJobStartTimeDesc());
				mailContent.append(",jobStatus:");
				mailContent.append(vo.getExecJobStatusDesc());
			}
			
			String title = mailTitle.toString();
			
			try {
				mailSendSpring.sendEmail(entry.getKey(), title.length() > 100? title.substring(0,100): title, mailContent.toString());
			} catch (Exception e) {
				LOGGER.error("log overtime mail send error:{}" , mailSends , e);
			}
		}
		
		
	}
	/**
	 *  检查PENDING任务丢失问题-- PENDING任务执行中，如果服务器重启情况
	 */
	private void pendingJobCronCheck() {
		
		JobLogQry qry = new JobLogQry();
		qry.setJobStatus(Arrays.asList(new String[]{CuckooJobExecStatus.PENDING.getValue()}));
		qry.setLimit(1000);
		for(int i = 0 ; ; i++){
			qry.setStart(i * qry.getLimit());
			PageDataList<CuckooJobExecLog> page = cuckooJobLogService.pageByQry(qry);
			List<CuckooJobExecLog> logs = page.getRows();
			if(CollectionUtils.isNotEmpty(logs)){
				
				for (CuckooJobExecLog cuckooJobExecLog : logs) {
					if(!quartzManage.checkSimpleExist(cuckooJobExecLog)){
						quartzManage.addSimpleJob(cuckooJobExecLog, ConfigUtil.getLong(CuckooJobConstant.CUCKOO_PENDING_JOB_RETRY_LONG, 60000L) );
					}
				}
			}else{
				break;
			}
		}
		
	}

	/**
	 * 检查未初始化的Cron任务 -- 用于支持SQL初始化任务
	 */
	private void cronQuartzInit() {
		
		CuckooJobDetailCriteria crt = new CuckooJobDetailCriteria();
		crt.createCriteria().andTriggerTypeEqualTo(CuckooJobTriggerType.CRON.getValue());
		List<CuckooJobDetail> jobs = cuckooJobDetailMapper.selectByExample(crt);
		
		for (CuckooJobDetail jobDetail : jobs) {
			if(!quartzManage.checkCronExists(String.valueOf(jobDetail.getId()))){
				// CRON任务在Cuckoo中有，但是在quartz中没有
				quartzManage.addCronJob(String.valueOf(jobDetail.getId()), jobDetail.getCronExpression(), CuckooJobStatus.fromName(jobDetail.getJobStatus()),  CuckooBooleanFlag.fromName(jobDetail.getTypeDaily()));
				if(CuckooJobStatus.PAUSE.getValue().equals(jobDetail.getJobStatus())){
					// 暂停状态
					quartzManage.pauseCronJob(String.valueOf(jobDetail.getId()));
				}
			}
		}
		
	}
	
 

}
