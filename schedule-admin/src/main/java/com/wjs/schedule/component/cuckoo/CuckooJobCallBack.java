package com.wjs.schedule.component.cuckoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.service.job.CuckooJobLogService;
import com.wjs.schedule.service.job.CuckooJobService;

/**
 * 客户端任务执行完成，调用方法
 * @author Silver
 *
 */
@Component("cuckooJobCallBack")
public class CuckooJobCallBack  {


	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooJobCallBack.class);
	@Autowired
	CuckooJobService cuckooJobService;
	
	@Autowired
	CuckooJobLogService cuckooJobLogService;
	
	@Autowired
	CuckooJobExecutor cuckooJobExecutor;
	/**
	 *  客户端任务执行成功回调
	 * @param jobInfo
	 */
	@Transactional
	public void execJobSuccedCallBack(JobInfoBean jobInfo) {
		
		CuckooJobExecLog jobLog = cuckooJobLogService.getJobLogByLogId(jobInfo.getJobLogId());
		
		// 更新日志
		cuckooJobLogService.updateJobLogStatusById(jobLog.getId(), CuckooJobExecStatus.SUCCED, jobInfo.getErrMessage());
		
		// 触发下级任务
		if(jobInfo.getNeedTrigglerNext()){

			cuckooJobExecutor.executeNextJob(jobInfo);
		}
	}
	
	/**
	 * 客户端任务执行失败回调
	 * @param jobInfo
	 */
	@Transactional
	public void execJobFailedCallBack(JobInfoBean jobInfo) {

		CuckooJobExecLog jobLog = cuckooJobLogService.getJobLogByLogId(jobInfo.getJobLogId());
		
		// 更新日志
		cuckooJobLogService.updateJobLogStatusById(jobLog.getId(), CuckooJobExecStatus.FAILED, jobInfo.getErrMessage());
	}

}
