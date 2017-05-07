package com.wjs.schedule.executor.framerwork.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooTaskBean {
	
	private String beanName;
	
	private String methodName;
	
	private String taskName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
