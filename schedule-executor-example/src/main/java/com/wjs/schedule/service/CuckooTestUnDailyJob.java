package com.wjs.schedule.service;

import com.wjs.schedule.bean.JobInfoBean;

public interface CuckooTestUnDailyJob {
	
	// 测试Cron触发非日切任务 -- 代码执行成功
	public void testCronUnDailySucced(JobInfoBean jobInfo);
	// 测试Cron触发非日切任务 -- 代码执行失败
	public void testCronUnDailyFailed(JobInfoBean jobInfo);
	// 测试Cron触发非日切有依赖任务 -- （非日切任务如果依赖过多，会造成不稳定，此处暂时不做支持）
//	public void testCronUnDailyDependencySucced(JobInfoBean jobInfo)
	

	// 测试上级任务触发非日切任务 -- 代码执行成功
	public void testFlowUnDailySucced(JobInfoBean jobInfo);
	

	// 测试上级任务触发非日切任务 -- 代码执行失败
	public void testFlowUnDailyFailed(JobInfoBean jobInfo);
	

	// 测试上级任务触发非日切有依赖任务  -- （非日切任务如果依赖过多，会造成不稳定，此处暂时不做支持）
//	public void testFlowUnDailyDependencySucced(JobInfoBean jobInfo);

}
