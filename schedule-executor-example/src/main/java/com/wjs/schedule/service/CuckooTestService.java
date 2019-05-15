package com.wjs.schedule.service;

import com.wjs.schedule.bean.JobInfoBean;

public interface CuckooTestService {


	// 测试任务 -- 代码执行成功
	public Object testJobSucced(JobInfoBean jobInfo);
	

	// 测试任务 -- 代码执行失败
	public Object testJobFailed(JobInfoBean jobInfo);
	
}
