package com.wjs.schedule.service.impl;

import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestTask;

@Service
public class CuckooTestTaskImpl implements CuckooTestTask {

	@Override
	@CuckooTask("testJob")
	public void testJob(JobInfoBean jobInfo) {
		// TODO Auto-generated method stub
		System.out.println("CuckooTestTaskImpl testJob");
	}

	@Override
	public void testJobTmp(JobInfoBean jobInfo) {
		// TODO Auto-generated method stub
		System.out.println("CuckooTestTaskImpl testJobTmp");
	}

}
