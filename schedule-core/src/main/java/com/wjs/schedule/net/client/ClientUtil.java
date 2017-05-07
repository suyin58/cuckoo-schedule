package com.wjs.schedule.net.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wjs.schedule.bean.ClientTaskInfoBean;
import com.wjs.schedule.bean.MessageInfo;
import com.wjs.schedule.constant.CuckooNetConstant;
import com.wjs.schedule.enums.CuckooMessageType;
import com.wjs.schedule.executor.framerwork.bean.ClientInfoBean;
import com.wjs.schedule.executor.framerwork.bean.CuckooTaskBean;
import com.wjs.schedule.executor.framerwork.cache.CuckooTaskCache;
import com.wjs.schedule.net.client.filter.ConnectFilter;
import com.wjs.schedule.net.client.handle.CuckooClientHandler;
import com.wjs.schedule.net.server.cache.IoServerCollection;
import com.wjs.schedule.net.server.cache.MessageSendQueue;
import com.wjs.schedule.net.vo.IoServerBean;

public class ClientUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientUtil.class);
	private static final Gson gson = new GsonBuilder().create();

	public static boolean connect(IoServerBean bean) {

		if (bean == null || bean.getIp() == null || bean.getPort() == null) {
			return false;
		}
		try {
			NioSocketConnector connector = new NioSocketConnector();
//			connector.getFilterChain().addLast("logger", new LoggingFilter());

			TextLineCodecFactory lineCodec = new TextLineCodecFactory(Charset.forName(CuckooNetConstant.ENCODING));
			lineCodec.setDecoderMaxLineLength(1024 * 1024); // 1M
			lineCodec.setEncoderMaxLineLength(1024 * 1024); // 1M
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(lineCodec));
			connector.getFilterChain().addLast("regist", new ConnectFilter());

			// // 设置连接超时检查时间
			connector.setConnectTimeoutCheckInterval(30);
			connector.setHandler(new CuckooClientHandler());

			// 建立连接
			ConnectFuture cf = connector.connect(new InetSocketAddress(bean.getIp(), bean.getPort()));
			// // 等待连接创建完成
			cf.awaitUninterruptibly();

			IoSession session = cf.getSession();
			bean.setSession(session);

			// 发送客户端注册消息
			// 连接创建后，需要将客户端的task（clienInfoBean）注解发送给服务器
			if (CollectionUtils.isNotEmpty(CuckooTaskCache.getCache())) {
				for (Iterator<CuckooTaskBean> it = CuckooTaskCache.getCache().iterator(); it.hasNext();) {
					CuckooTaskBean taskBean = it.next();
					ClientTaskInfoBean taskInfo = new ClientTaskInfoBean();
					taskInfo.setAppName(ClientInfoBean.getAppName());
					taskInfo.setClientTag(ClientInfoBean.getClientTag());
					taskInfo.setBeanName(taskBean.getBeanName());
					taskInfo.setMethodName(taskBean.getMethodName());
					taskInfo.setTaskName(taskBean.getTaskName());
					ClientUtil.send(CuckooMessageType.REGIST, session, taskInfo);
				}

			}
			LOGGER.info("cuckoo job succed to connect server,Ip:{},port:{}", bean.getIp(), bean.getPort());
			//
			// cf.getSession().write("Hi Server!");
			// cf.getSession().write("quit");
			//
			// // 等待连接断开
			// cf.getSession().getCloseFuture().awaitUninterruptibly();
			// // 释放连接
			// connector.dispose();
		} catch (Exception e) {

			return false;
		}

		return true;
	}



	// 给所有服务器发消息
	public static void send(CuckooMessageType messageType, Object message) {

		// 给服务端发消息
		MessageInfo msgInfo = new MessageInfo();
		msgInfo.setMessage(message);
		msgInfo.setMessageType(messageType);

		if (!sendMessageInfo(msgInfo)) {
			// offer 添加一个元素并返回true 如果队列已满,或者异常情况，则返回false
			MessageSendQueue.instance().getQueue().offer(msgInfo);
		}
	}
	
	

	// 给所有服务器发消息
	public static boolean sendMessageInfo(MessageInfo msgInfo) {
		if (CollectionUtils.isNotEmpty(IoServerCollection.getSet())) {
			for (Iterator<IoServerBean> it = IoServerCollection.getSet().iterator(); it.hasNext();) {
				IoServerBean server = it.next();
				if (null != server.getSession()) {
					ClientUtil.send(msgInfo.getMessageType(), server.getSession(), msgInfo.getMessage());
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 给一台服务器发消息
	 * 
	 * @param messageType
	 * @param session
	 * @param message
	 */
	public static void send(CuckooMessageType messageType, IoSession session, Object message) {

		try {
			// 给服务端发消息
			MessageInfo msgInfo = new MessageInfo();
			msgInfo.setMessage(message);
			msgInfo.setMessageType(messageType);
			String msg = gson.toJson(msgInfo);

			LOGGER.info("客户端发送消息:server:{}, msg:{}", session.getLocalAddress(), msg);
			session.write(msg);
		} catch (Exception e) {
			LOGGER.error("client message send error:{}", e.getMessage(), e);
		}
	}

}
