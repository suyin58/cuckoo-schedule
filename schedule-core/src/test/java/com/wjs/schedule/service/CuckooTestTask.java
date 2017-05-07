package com.wjs.schedule.service;

import com.wjs.schedule.bean.JobInfoBean;

public interface CuckooTestTask {
	
	public void testJob(JobInfoBean jobInfo);
	public void testJobTmp(JobInfoBean jobInfo);

}
