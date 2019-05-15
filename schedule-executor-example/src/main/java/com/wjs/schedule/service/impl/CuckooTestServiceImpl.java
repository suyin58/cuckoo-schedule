package com.wjs.schedule.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestService;

@Service("cuckooTestService")
public class CuckooTestServiceImpl implements CuckooTestService {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooTestServiceImpl.class);


	@Override
	@CuckooTask
	public Object testJobSucced(JobInfoBean jobInfo) {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowDailySucced:{}",  jobInfo);
		
		return "执行成功";
		
	}


	@Override
	@CuckooTask("testCronDailyFailed")
	public Object testJobFailed(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}

		LOGGER.info("Client exec done ,testCronDailySucced:{}",  jobInfo);
		throw new RuntimeException("执行失败");
		
	}

}
