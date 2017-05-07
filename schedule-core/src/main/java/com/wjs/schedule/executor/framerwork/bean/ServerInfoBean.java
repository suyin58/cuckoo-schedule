package com.wjs.schedule.executor.framerwork.bean;

public class ServerInfoBean {

	private static String ip;
	
	private static int port;

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		ServerInfoBean.ip = ip;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		ServerInfoBean.port = port;
	}
	
	
}
