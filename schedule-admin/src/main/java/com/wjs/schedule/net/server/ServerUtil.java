package com.wjs.schedule.net.server;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wjs.schedule.bean.MessageInfo;
import com.wjs.schedule.enums.CuckooMessageType;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.net.vo.IoClientInfo;

public class ServerUtil {


	private static final Logger LOGGER = LoggerFactory.getLogger(ServerUtil.class);
	private static final Gson gson = new GsonBuilder().create();
	
	public static void send(IoClientInfo clientInfo, CuckooMessageType messageType, Object message) {
		
		IoSession session = clientInfo.getSession();
		if(null == session){
			LOGGER.info("could not get session from clientInfo:{}", clientInfo);
			throw new BaseException("could not get session from clientInfo:{}", clientInfo);
		}
		
		
		// 给服务端发消息
		MessageInfo msgInfo = new MessageInfo();
		msgInfo.setMessage(message);
		msgInfo.setMessageType(messageType);
		String msg = gson.toJson(msgInfo);
		
		try {
			session.write(msg);
			LOGGER.info("server send message succed:server:{}, msg:{}",session.getLocalAddress(), msg);
		} catch (Exception e) {
			LOGGER.info("server send message failed:server:{}, msg:{},error:{}",session.getLocalAddress(), msg ,e.getMessage() ,e);
			throw new BaseException("server send message failed:server:{}, msg:{},error:{}",session.getLocalAddress(), msg ,e.getMessage());
		}
		
	}

}
