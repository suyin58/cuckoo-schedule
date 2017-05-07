package com.wjs.schedule.net.server.cache;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.net.client.ClientUtil;
import com.wjs.schedule.net.vo.IoServerBean;

public class IoServerCollection {

	private static final Logger LOGGER = LoggerFactory.getLogger(IoServerCollection.class);

	private static Set<IoServerBean> set = new HashSet<>();

	private IoServerCollection() {
		super();
	}

	public static boolean add(IoServerBean bean) {
		return set.add(bean);
	}

	public static Set<IoServerBean> getSet() {
		return set;
	}

	public static void remove(InetSocketAddress clientAddr) {

		String ip = clientAddr.getAddress().getHostAddress();
		Integer port = clientAddr.getPort();
		remove(ip, port);
	}

	private static void remove(String ip, Integer port) {

		for (Iterator<IoServerBean> it = set.iterator(); it.hasNext();) {
			IoServerBean bean = it.next();
			if (bean.getIp().equals(ip) && bean.getPort().equals(port)) {
				it.remove();
			}
		}

	}

	/*
	 * retry connect to server,in case of server resart
	 */
	public static void retryConnect() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (;;) {
					try {
						Set<IoServerBean> servers = IoServerCollection.getSet();
						if (CollectionUtils.isNotEmpty(servers)) {

							List<IoServerBean> unConnect = new ArrayList<>();
							for (IoServerBean ioServerBean : servers) {
								if (null == ioServerBean.getSession()) {
									if (!ClientUtil.connect(ioServerBean)) {
										unConnect.add(ioServerBean);
									}
								}
							}
							if(CollectionUtils.isNotEmpty(unConnect)){
								LOGGER.warn("cuckoo unconnection to server:{}", unConnect);
							}

						}

						Thread.sleep(60000);
					} catch (InterruptedException e) {
						LOGGER.error("unknow error:{}", e.getMessage(), e);
					}
				}
			}
		}).start();
		LOGGER.info("retry connect thread start");
	}

}
