package com.wjs.schedule.controller;	
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.executor.annotation.CuckooTask;

@Controller
@RequestMapping("/test")
public class CuckooTestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooTestController.class);

	@RequestMapping("/succed")
	@ResponseBody
	@CuckooTask
	public Object testsucced(JobInfoBean jobInfo) {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("HTTP exec done ,testsucced:{}",  jobInfo);
		
		return "执行成功";
	}
	
	
	@RequestMapping("/failed")
	@ResponseBody
	@CuckooTask
	public Object testfailed(JobInfoBean jobInfo) {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			LOGGER.error("thread error,{}", e.getMessage());
		}
		LOGGER.info("HTTP exec done ,testfailed:{}",  jobInfo);
		throw new RuntimeException("执行失败");
	}
}

