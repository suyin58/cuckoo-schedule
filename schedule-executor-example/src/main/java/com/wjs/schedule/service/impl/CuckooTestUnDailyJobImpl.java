package com.wjs.schedule.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;
import com.wjs.schedule.service.CuckooTestUnDailyJob;

@Service
public class CuckooTestUnDailyJobImpl implements CuckooTestUnDailyJob {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooTestUnDailyJobImpl.class);
	
	

	int time = 60*10 * 1000;
	@Override
	@CuckooTask("testCronUnDailySucced")
	public void testCronUnDailySucced(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testCronUnDailySucced:{}" , jobInfo );
	}

	@Override
	@CuckooTask("testCronUnDailyFailed")
	public void testCronUnDailyFailed(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testCronUnDailyFailed:{}",  jobInfo);
//		if(new Random().nextInt(10) == 1){
//			// 偶尔报错
//			throw new BaseException("client throw a exception ");
//		}
	}

	@Override
	@CuckooTask("testFlowUnDailySucced")
	public void testFlowUnDailySucced(JobInfoBean jobInfo) {
		// 测试完成
		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowUnDailySucced:{}",  jobInfo);
	}

	@Override
	@CuckooTask("testFlowUnDailyFailed")
	public void testFlowUnDailyFailed(JobInfoBean jobInfo) {
		// 测试完成

		try {
			Thread.sleep(new Random().nextInt(time ));
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("Client exec done ,testFlowUnDailyFailed:{}",  jobInfo);
//		if(new Random().nextInt(10) == 1){
//			// 偶尔报错
//			throw new BaseException("client throw a exception ");
//		}
	}

}
