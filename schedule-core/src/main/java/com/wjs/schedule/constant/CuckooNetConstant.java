package com.wjs.schedule.constant;

public class CuckooNetConstant {
	
	public static final String ENCODING = "UTF-8";
	
	public static final String CUCKOO_SERVER_TCPPORT = "cuckoo.server.tcpPort";
	
	/**
	 * 服务器不活跃超时丢弃时间
	 */
	public static final Long CUCKOO_NET_SERVER_OVERTIME = 600000L;
	
	/**
	 * 执行器不会越超时丢弃时间
	 */
	public static final Long CUCKOO_NET_CLIENT_OVERTIME = 300000L;
	
}
