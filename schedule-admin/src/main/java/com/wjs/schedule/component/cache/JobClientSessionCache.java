package com.wjs.schedule.component.cache;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.net.vo.IoClientInfo;

public class JobClientSessionCache {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JobClientSessionCache.class);
	
	/**
	 * 客户端连接缓存 Map<clientId,Socket>
	 */
	private static ConcurrentHashMap<Long, IoClientInfo> channel = new ConcurrentHashMap<Long, IoClientInfo>();

	private JobClientSessionCache() {
		super();
	}

	public static IoClientInfo get(Long clientId) {

		return channel.get(clientId);
	}

	public static void put(Long clientId, IoClientInfo socket) {

		channel.put(clientId, socket);
	}

	public static void remove(Long clientId) {
		
		IoClientInfo  clientInfo = channel.get(clientId);
		if(null != clientInfo){
			IoSession session = clientInfo.getSession();
			if(null != session){
				try {
					session.close(true);
				} catch (Exception e) {
					LOGGER.error("session close immediately error:{}", e.getMessage() , e);
				}
			}
		}
		channel.remove(clientId);
	}

	public static void remove(IoSession session) {

		// 遍历缓存数据,由于可能有多台服务器，此处仅删除本机缓存。数据库记录信息不做处理
		for (Iterator<Entry<Long, IoClientInfo>> it = channel.entrySet().iterator(); it.hasNext();) {
			Entry<Long, IoClientInfo> entry = it.next();
			if (session.equals(entry.getValue().getSession())) {
				it.remove();
			}
		}
	}

}
