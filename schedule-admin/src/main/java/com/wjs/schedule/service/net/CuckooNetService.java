package com.wjs.schedule.service.net;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.exception.JobCanNotRunningException;
import com.wjs.schedule.exception.JobRunningErrorException;
import com.wjs.schedule.vo.job.CuckooClientJobExecResult;

public interface CuckooNetService {

	/**
	 * 调用远程任务
	 * @param jobBean
	 */
	CuckooClientJobExecResult execRemoteJob(JobInfoBean jobBean) throws JobCanNotRunningException, JobRunningErrorException ;
	

}
