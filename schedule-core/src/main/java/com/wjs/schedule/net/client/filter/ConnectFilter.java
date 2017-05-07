package com.wjs.schedule.net.client.filter;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.net.server.cache.IoServerCollection;
import com.wjs.schedule.net.vo.IoServerBean;

/**
 * 监听客户端连接，断开，异常操作。相关操作需要修改数据库，并修改缓存
 * 
 * @author Silver
 *
 */
public class ConnectFilter extends IoFilterAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectFilter.class);

	/**
	 * 这个方法在你的程序、Mina 自身出现异常时回调，一般这里是关闭IoSession。
	 */
	@Override
	public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {

		InetSocketAddress clientAddr = (InetSocketAddress) session.getRemoteAddress();
		LOGGER.error("服务端异常:{}", clientAddr.toString());
		// 删除 链接
		IoServerCollection.remove(clientAddr);
		// 新增待连接信息
		IoServerBean bean = new IoServerBean();
		bean.setIp(clientAddr.getAddress().getHostAddress());
		bean.setPort(clientAddr.getPort());
		IoServerCollection.add(bean);
		super.exceptionCaught(nextFilter, session, cause);

	}

	/**
	 * 在调用添加到链中的方法后被调，如果在这个方法中有异常抛出，则过滤器会立即被移除，
	 * 同时destroy()方法也会被调用（前提是使用ReferenceCountingFilter包装）。
	 */
	@Override
	public void onPostAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
		super.onPostAdd(parent, name, nextFilter);
	}

	/**
	 * 在从链中移除之后调用。
	 */
	@Override
	public void onPostRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
		super.onPostRemove(parent, name, nextFilter);
	}

	/**
	 * 这个方法当一个Session 对象被创建的时候被调用。 对于TCP 连接来说，连接被接受的时候调用，但要注意此时TCP
	 * 连接并未建立，此方法仅代表字面含义， 也就是连接的对象IoSession 被创建完毕的时候，回调这个方法。 对于UDP
	 * 来说，当有数据包收到的时候回调这个方法，因为UDP 是无连接的。
	 */
	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
		super.sessionCreated(nextFilter, session);
	}

	/**
	 * 这个方法在连接被打开时调用，它总是在sessionCreated()方法之后被调用。 对于TCP
	 * 来说，它是在连接被建立之后调用，你可以在这里执行一些认证操作、发送数据等。 对于UDP
	 * 来说，这个方法与sessionCreated()没什么区别，但是紧跟其后执行。如果你每隔一段时间，发送一些数据，那么sessionCreated(
	 * )方法只会在第一次调用，但是sessionOpened()方法每次都会调用。
	 */
	@Override
	public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
		super.sessionOpened(nextFilter, session);
	}

	/**
	 * 对于TCP 来说，连接被关闭时，调用这个方法。 对于UDP 来说，IoSession 的close()方法被调用时才会毁掉这个方法。
	 */
	@Override
	public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {

		InetSocketAddress clientAddr = (InetSocketAddress) session.getRemoteAddress();
		LOGGER.error("服务端异常:{}", clientAddr.toString());
		// 删除 链接
		IoServerCollection.remove(clientAddr);

		// 新增待连接信息
		IoServerBean bean = new IoServerBean();
		bean.setIp(clientAddr.getAddress().getHostAddress());
		bean.setPort(clientAddr.getPort());
		IoServerCollection.add(bean);
		super.sessionClosed(nextFilter, session);
	}

	/**
	 * 这个方法在IoSession 的通道进入空闲状态时调用，对于UDP 协议来说，这个方法始终不会被调用。
	 */
	@Override
	public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {

		System.err.println("sessionIdle");
		super.sessionIdle(nextFilter, session, status);
	}

}
