package com.wjs.schedule.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestDailyJob;

@Service
public class CuckooTestDailyJobImpl implements CuckooTestDailyJob {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooTestDailyJobImpl.class);

//	int time = 60*60*1 * 1000;
	int time = 10 * 1000;
	@Override
	@CuckooTask("testCronDailySucced")
	public void testCronDailySucced(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		
		LOGGER.info("Client exec done ,testCronDailySucced:{}",  jobInfo);
	}

	@Override
	@CuckooTask("testCronDailyFailed")
	public void testCronDailyFailed(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testCronDailySucced:{}",  jobInfo);
//		if(new Random().nextInt(10) == 1){
//			// 偶尔报错
//			throw new BaseException("client throw a exception ");
//		}
	}

	@Override
	@CuckooTask("testCronDailyDependencySucced")
	public void testCronDailyDependencySucced(JobInfoBean jobInfo) {
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testCronDailyDependencySucced:{}",  jobInfo);
	}

	@Override
	@CuckooTask("testFlowDailySucced")
	public void testFlowDailySucced(JobInfoBean jobInfo) {
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowDailySucced:{}",  jobInfo);
		
	}

	@Override
	@CuckooTask("testFlowDailyFailed")
	public void testFlowDailyFailed(JobInfoBean jobInfo) {
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowDailyFailed:{}",  jobInfo);
//		if(new Random().nextInt(10) == 1){
//			// 偶尔报错
//			throw new BaseException("client throw a exception ");
//		}
		
	}

	@Override
	@CuckooTask("testFlowDailyDependencySucced")
	public void testFlowDailyDependencySucced(JobInfoBean jobInfo) {
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowDailyDependencySucced:{}",  jobInfo);
		
	}

}
