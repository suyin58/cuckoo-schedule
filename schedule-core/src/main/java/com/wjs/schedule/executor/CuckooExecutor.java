package com.wjs.schedule.executor;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.executor.framerwork.CuckooClient;
import com.wjs.schedule.executor.framerwork.bean.CuckooTaskBean;

public class CuckooExecutor {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooExecutor.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void exec(CuckooTaskBean task, JobInfoBean taskParam) {
		
		
		ApplicationContext applicationContext = CuckooClient.getApplicationContext();
		Object obj = applicationContext.getBean(task.getBeanName());

		try {
			Class claz = obj.getClass();
			Method method = claz.getMethod(task.getMethodName(), JobInfoBean.class);
			method.invoke(obj, taskParam);
		} catch (BaseException e) {
			LOGGER.error("task executor occor a biz exception:{}", e.getMessage() , e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("task executor occor a unknow error:{}", e.getMessage() , e);
			throw new BaseException("task executor occor a unknow error:{}", e.getMessage());
		}
	}
}
