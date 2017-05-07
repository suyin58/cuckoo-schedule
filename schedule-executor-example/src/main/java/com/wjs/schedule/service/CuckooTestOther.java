package com.wjs.schedule.service;

import com.wjs.schedule.bean.JobInfoBean;

public interface CuckooTestOther {

	

	public void testCronJobAutoInit(JobInfoBean jobInfo);
	
	
	public void testCronJobOverTime(JobInfoBean jobInfo);
}
