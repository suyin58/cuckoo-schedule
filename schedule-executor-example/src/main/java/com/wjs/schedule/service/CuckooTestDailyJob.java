package com.wjs.schedule.service;

import com.wjs.schedule.bean.JobInfoBean;

public interface CuckooTestDailyJob {


	// 测试Cron触日切任务 -- 代码执行成功
	public void testCronDailySucced(JobInfoBean jobInfo);
	

	// 测试Cron触日切任务 -- 代码执行失败
	public void testCronDailyFailed(JobInfoBean jobInfo);
	
	// 测试Cron触发日切有依赖任务 
	public void testCronDailyDependencySucced(JobInfoBean jobInfo);
	
	// 测试上级任务触发日切任务 -- 代码执行成功
	public void testFlowDailySucced(JobInfoBean jobInfo);
	

	// 测试上级任务触发日切任务 -- 代码执行失败
	public void testFlowDailyFailed(JobInfoBean jobInfo);
	

	// 测试上级任务触发日切有依赖任务 
	public void testFlowDailyDependencySucced(JobInfoBean jobInfo);
}
