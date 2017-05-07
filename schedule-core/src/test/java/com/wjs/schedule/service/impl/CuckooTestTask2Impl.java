package com.wjs.schedule.service.impl;

import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestTask2;

@Service
public class CuckooTestTask2Impl implements CuckooTestTask2 {

	@Override
	@CuckooTask("testJob2")
	public void testJob(JobInfoBean jobInfo) {

		// TODO Auto-generated method stub
		System.out.println("CuckooTestTask2Impl testJob");
	}

}
