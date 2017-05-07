package com.wjs.schedule.net.server;

import java.net.InetSocketAddress;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.dao.net.CuckooNetClientInfoMapper;
import com.wjs.schedule.dao.net.CuckooNetServerInfoMapper;
import com.wjs.schedule.domain.net.CuckooNetClientInfo;
import com.wjs.schedule.domain.net.CuckooNetClientInfoCriteria;
import com.wjs.schedule.domain.net.CuckooNetServerInfo;
import com.wjs.schedule.domain.net.CuckooNetServerInfoCriteria;
import com.wjs.schedule.enums.CuckooMessageType;

public class MinaHeartBeatMessageFactory implements KeepAliveMessageFactory {

	
	@Autowired
	CuckooNetServerInfoMapper cuckooNetServerInfoMapper;
	
	@Autowired
	CuckooNetClientInfoMapper cuckooNetClinetInfoMapper;
	
//	private static final Gson gson = new GsonBuilder().create();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MinaHeartBeatMessageFactory.class);
	public Object getRequest(IoSession session) {
		
//		LOGGER.info("getRequest" + session.getRemoteAddress()); // 客户端：10.138.254.70:53266
//		LOGGER.info("getRequest" + session.getServiceAddress()); // 服务端 ：0.0.0.0:10115
//		LOGGER.info("getRequest" + session.getLocalAddress()); // 服务端:10.138.254.10:10115

		LOGGER.debug("request heart beat set: " + CuckooMessageType.HEARTBEATSERVER.getValue() + session.getRemoteAddress());
		InetSocketAddress serverAddr = (InetSocketAddress)session.getLocalAddress();
		InetSocketAddress clientAddr = (InetSocketAddress)session.getRemoteAddress();
		
		try {
			// 更新服务端活跃时间
			updateServerStatus(serverAddr);
			
			// 更新客户端活跃时间（如果客户端长时间不活跃，可以通过QuartzAutoJobExecutor删除尝试建不活跃的client_info和client_regiest_map）
			updateClinetStatus(clientAddr);
		} catch (Exception e) {
			LOGGER.error("Unknown error :{}", e.getMessage() , e);
		}
		
		return CuckooMessageType.HEARTBEATSERVER.getValue();
//		return gson.toJson(messageInfo);
	}

	
	/*
	 * 更新客户端活跃时间
	 * （如果客户端长时间不活跃，可以通过QuartzAutoJobExecutor删除尝试建不活跃的client_info和client_regiest_map）
	 */
	private void updateClinetStatus(InetSocketAddress clientAddr) {
		
		CuckooNetClientInfoCriteria clientCrt = new CuckooNetClientInfoCriteria();
		clientCrt.createCriteria().andIpEqualTo(clientAddr.getAddress().getHostAddress())
		.andPortEqualTo(clientAddr.getPort());
		
		CuckooNetClientInfo updateTime = new CuckooNetClientInfo();
		updateTime.setModifyDate(System.currentTimeMillis());
		
		cuckooNetClinetInfoMapper.updateByExampleSelective(updateTime, clientCrt);
	}

	private void updateServerStatus(InetSocketAddress serverAddr) {
		CuckooNetServerInfoCriteria serverCrt = new CuckooNetServerInfoCriteria();
		serverCrt.createCriteria().andIpEqualTo(serverAddr.getAddress().getHostAddress())
		.andPortEqualTo(serverAddr.getPort());
		
		CuckooNetServerInfo updateTime = new CuckooNetServerInfo();
		updateTime.setModifyDate(System.currentTimeMillis());
		
		cuckooNetServerInfoMapper.updateByExampleSelective(updateTime, serverCrt);
	}

	public Object getResponse(IoSession session, Object request) {

		LOGGER.info("response heart beat set: " + CuckooMessageType.HEARTBEATCLIENT.getValue());
		

//		LOGGER.info("getResponse" + session.getRemoteAddress());
//		LOGGER.info("getResponse" + session.getServiceAddress());
//		LOGGER.info("getResponse" + session.getLocalAddress());
//		LOGGER.info("getResponse" + request);
		/** 返回预设语句 */
		return CuckooMessageType.HEARTBEATCLIENT.getValue();
	}

	public boolean isRequest(IoSession session, Object message) {
		


//		LOGGER.info("isRequest" + session.getRemoteAddress());
//		LOGGER.info("isRequest" + session.getServiceAddress());
//		LOGGER.info("isRequest" + session.getLocalAddress());
//		LOGGER.info("isRequest" + message);

		if (message.equals(CuckooMessageType.HEARTBEATSERVER.getValue())) {
			LOGGER.debug("request heart beat get : " + message.toString());
			// 服务端信息管理
			return true;
		}
		return false;
	}

	public boolean isResponse(IoSession session, Object message) {
		

//		LOGGER.info("isResponse" + session.getRemoteAddress());
//		LOGGER.info("isResponse" + session.getServiceAddress());
//		LOGGER.info("isResponse" + session.getLocalAddress());
//		LOGGER.info("isResponse" + message);
		
		if (message.equals(CuckooMessageType.HEARTBEATCLIENT.getValue())) {
			LOGGER.debug("response heart beat get : " + message.toString());
			return true;
		}
		return false;
	}
}