package com.wjs.schedule.net.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wjs.schedule.enums.CuckooMessageType;
import com.wjs.util.http.HttpClientUtils;

public class ClientUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientUtil.class);

	
	private String uri;
	
	


	
	public String getUri() {
	
		return uri;
	}




	
	public void setUri(String uri) {
	
		this.uri = uri;
	}




	/**
	 * 给一台服务器发消息
	 * 
	 * @param messageType
	 * @param session
	 * @param message
	 */
	public void send(CuckooMessageType messageType,  Object message) {

		try {
			// 给服务端发消息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("messageType", messageType.getValue());
			map.put("message", JSON.toJSON(message));
			HttpClientUtils.postSSLWithoutException(uri + "/callback", map);

			LOGGER.info("客户端发送消息:server:{}, msg:{}", uri, message);
		} catch (Exception e) {
			LOGGER.error("client message send error:{}", e.getMessage(), e);
		}
	}

}
