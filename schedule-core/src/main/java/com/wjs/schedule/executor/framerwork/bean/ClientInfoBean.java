package com.wjs.schedule.executor.framerwork.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 客户端信息，用于存储clientTag
 * @author Silver
 *
 */
public class ClientInfoBean {


	private static String appName;
	
	private static String clientTag;
	
	private ClientInfoBean(){
		
	}


	public static String getAppName() {
		return appName;
	}

	public static void setAppName(String appName) {
		ClientInfoBean.appName = appName;
	}
	
	

	public static String getClientTag() {
		return clientTag;
	}


	public static void setClientTag(String clientTag) {
		ClientInfoBean.clientTag = clientTag;
	}


	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}

}
