package com.wjs.schedule.component.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wjs.schedule.component.cuckoo.CuckooJobExecutor;
import com.wjs.schedule.constant.CuckooJobConstant;
import com.wjs.schedule.dao.exec.CuckooJobDetailMapper;
import com.wjs.schedule.dao.exec.CuckooJobExecLogMapper;
import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.exception.JobUndailyLogBreakException;
import com.wjs.schedule.service.job.CuckooJobLogService;
import com.wjs.schedule.service.job.CuckooJobService;

@Component("quartzJobExecutor")
public class QuartzJobExecutor extends QuartzJobBean {


	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJobExecutor.class);

	@Autowired
	CuckooJobDetailMapper cuckooJobDetailMapper;
	
	@Autowired
	CuckooJobExecLogMapper cuckooJobExecLogMapper;
	
	@Autowired
	CuckooJobExecutor cuckooJobExecutor;
	
	@Autowired
	CuckooJobService cuckooJobService;
	

	@Autowired
	CuckooJobLogService cuckooJobLogService;
	
	@Autowired
	QuartzManage quartzExec;
	
	@Override
	@Transactional
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		Trigger trigger = context.getTrigger();
		JobKey jobKey = trigger.getJobKey();
		
		Date scheduledFireTime = context.getScheduledFireTime();
//		if("15".equals(jobKey.getName())){
//			System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(scheduledFireTime));
//		}
		
//		JobDataMap data = context.getMergedJobDataMap();
//		Object execIdObj = data.get(CuckooJobConstant.JOB_EXEC_ID);
		CuckooJobExecLog cuckooJobExecLog= null;
		String quartzJobGroup = jobKey.getGroup();
		String[] quartzJobNameArr = jobKey.getName().split(CuckooJobConstant.QUARTZ_JOBNAME_JOINT);
		if (quartzJobNameArr.length < 1) {
			LOGGER.error("Unformat quartz Job ,group:{},name:{} ", quartzJobGroup, jobKey.getName());
			throw new BaseException("Unformat quartz Job ,group:{},name:{} ", quartzJobGroup, jobKey.getName());
		}
		
		if(trigger instanceof CronTriggerImpl){
			// cron 任务jobName == jobId
			// 如果日志ID为空，表示当前任务为CRON触发，新增执行日志(一般情况为任务调度节点的第一个任务)
			LOGGER.info("quartz trigger cron job, jobGroup:{},jobName:{},triggerType:{}", jobKey.getGroup(), quartzJobNameArr,trigger.getClass());
			
			
			Long cuckooJobId = Long.valueOf(quartzJobNameArr[0]);

			// 根据jobId找到任务信息
			final CuckooJobDetail cuckooJobDetail = cuckooJobDetailMapper.lockByPrimaryKey(cuckooJobId);
			if (null == cuckooJobDetail) {
				LOGGER.error("can not find cuckoojob in quartzExecutor by jobGroup:{},jobName:{}", jobKey.getGroup(),
						jobKey.getName());
				throw new BaseException("can not find cuckoojob in quartzExecutor by jobGroup:{},jobName:{}",
						jobKey.getGroup(), jobKey.getName());
			}
			try {
				cuckooJobExecLog = cuckooJobLogService.initSysCronJobLog(cuckooJobDetail, scheduledFireTime);
			} catch (JobUndailyLogBreakException e) {

				LOGGER.error("init log error:{}", e.getMessage());
				return ;
			}
			
		}else if(trigger instanceof SimpleTriggerImpl){
			// Simple jobName == jobId_logId
			Long execIdObj = Long.valueOf(quartzJobNameArr[1]);
			LOGGER.debug("quartz trigger flow job, jobGroup:{},jobName:{},execIdObj:{},triggerType:{}", jobKey.getGroup(), jobKey.getName(), execIdObj,trigger.getClass());

			Long execId = Long.valueOf(String.valueOf(execIdObj));
			// 如果日志ID不为空，表示当前日志是通过上级任务触发或者是有等待执行的任务
			cuckooJobExecLog = cuckooJobExecLogMapper.selectByPrimaryKey(execId);
		}
		 

		

		if(!cuckooJobExecutor.executeQuartzJob(cuckooJobExecLog)){
			
			cuckooJobService.rependingJob(cuckooJobExecLog);
		};

	}
	

}
