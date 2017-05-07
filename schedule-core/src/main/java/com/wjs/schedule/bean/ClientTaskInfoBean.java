package com.wjs.schedule.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ClientTaskInfoBean {
	
	private String appName;
	
	private String beanName;
	
	private String methodName;
	
	private String taskName;
	
	private String clientTag;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

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
	
	
	
	public String getClientTag() {
		return clientTag;
	}

	public void setClientTag(String clientTag) {
		this.clientTag = clientTag;
	}

	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
