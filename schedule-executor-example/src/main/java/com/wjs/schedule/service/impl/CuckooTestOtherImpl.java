package com.wjs.schedule.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestOther;

@Service("cuckooTestOther")
public class CuckooTestOtherImpl implements CuckooTestOther {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooTestOtherImpl.class);

	@Override
	@CuckooTask("testCronJobAutoInit")
	public void testCronJobAutoInit(JobInfoBean jobInfo) {

		LOGGER.info("Client exec done ,testCronJobAutoInit:{}",  jobInfo);
	}

	@Override
	@CuckooTask("testCronJobOverTime")
	public void testCronJobOverTime(JobInfoBean jobInfo) {
		
		try {
			Thread.sleep(60 * 60 * 1000);
		} catch (InterruptedException e) {
			throw new BaseException(e.getMessage());
		}
		LOGGER.info("Client exec done ,testCronJobOverTime:{}",  jobInfo);
	}

}
