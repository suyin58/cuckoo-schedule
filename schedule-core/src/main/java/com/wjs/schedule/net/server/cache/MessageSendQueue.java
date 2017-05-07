package com.wjs.schedule.net.server.cache;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.bean.MessageInfo;
import com.wjs.schedule.net.client.ClientUtil;

public class MessageSendQueue {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageSendQueue.class);

	private static MessageSendQueue instance;

	private MessageSendQueue() {

	}

	public static MessageSendQueue instance() {
		synchronized (MessageSendQueue.class) {
			if (null == instance) {
				instance = new MessageSendQueue();
			}
		}
		return instance;
	}

	private volatile Queue<MessageInfo> queue = new ConcurrentLinkedQueue<MessageInfo>();

	public Queue<MessageInfo> getQueue() {
		return queue;
	}

	public static void trySendMessage() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						LOGGER.info("messagesendqueue size:{}",  MessageSendQueue.instance().getQueue().size());
						if (0 == MessageSendQueue.instance().getQueue().size()) {
							break;
						}
						LOGGER.info("messagesendqueue queue:{}",  MessageSendQueue.instance().getQueue());
						for (int i = 0; i < MessageSendQueue.instance().getQueue().size(); i++) {
							// ** poll 移除并返问队列头部的元素 如果队列为空，则返回null
							final MessageInfo message = MessageSendQueue.instance().getQueue().poll();
							if (null == message) {
								break;
							}

							LOGGER.info("messagesendqueue resend:{}",  message);
							ClientUtil.sendMessageInfo(message);
						}

						Thread.sleep(30000);

					} catch (Exception e) {
						LOGGER.error("unknow error:{}", e.getMessage(), e);
					}
				}

			}
		}).start();
		LOGGER.info("retry Send Message thread start");
	}

}
