package com.wjs.schedule.net.server.filter;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.component.cache.JobClientSessionCache;
import com.wjs.schedule.dao.exec.CuckooJobExecLogMapper;
import com.wjs.schedule.dao.net.CuckooNetClientInfoMapper;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.domain.exec.CuckooJobExecLogCriteria;
import com.wjs.schedule.domain.net.CuckooNetClientInfo;
import com.wjs.schedule.domain.net.CuckooNetClientInfoCriteria;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.service.job.CuckooJobLogService;
import com.wjs.schedule.service.net.CuckooNetService;

/**
 * 监听客户端连接，断开，异常操作。相关操作需要修改数据库，并修改缓存
 * @author Silver
 *
 */
public class RegistFilter extends IoFilterAdapter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistFilter.class);


	@Autowired
	CuckooNetClientInfoMapper cuckooNetClientInfoMapper;
	
	
	@Autowired
	CuckooJobExecLogMapper cuckooJobExecLogMapper;
	
	@Autowired
	CuckooJobLogService cuckooJobLogService;
	
	@Autowired 
	CuckooNetService cuckooNetService;
	
	/**
	 这个方法在你的程序、Mina 自身出现异常时回调，一般这里是关闭IoSession。
	 */
	@Override
	public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
		
		SocketAddress clientAddr = session.getRemoteAddress();
		LOGGER.error("客户端异常:{}", clientAddr.toString());
	
		JobClientSessionCache.remove(session);
		
		super.exceptionCaught(nextFilter, session, cause);
		
	}

	/**
	 在调用添加到链中的方法后被调，如果在这个方法中有异常抛出，则过滤器会立即被移除，
	 同时destroy()方法也会被调用（前提是使用ReferenceCountingFilter包装）。
	 */
	@Override
	public void onPostAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
//		System.err.println("onPostAdd");
		super.onPostAdd(parent, name, nextFilter);
	}

	/**
	 在从链中移除之后调用。
	 */
	@Override
	public void onPostRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {

//		System.err.println("onPostRemove");
		super.onPostRemove(parent, name, nextFilter);
	}

	/**
	 这个方法当一个Session 对象被创建的时候被调用。
	 	对于TCP 连接来说，连接被接受的时候调用，但要注意此时TCP 连接并未建立，此方法仅代表字面含义， 也就是连接的对象IoSession 被创建完毕的时候，回调这个方法。
	 	对于UDP 来说，当有数据包收到的时候回调这个方法，因为UDP 是无连接的。
	 */
	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {

//		System.err.println("sessionCreated");
		super.sessionCreated(nextFilter, session);
	}

	/**
	 这个方法在连接被打开时调用，它总是在sessionCreated()方法之后被调用。
	 对于TCP 来说，它是在连接被建立之后调用，你可以在这里执行一些认证操作、发送数据等。
	 对于UDP 来说，这个方法与sessionCreated()没什么区别，但是紧跟其后执行。如果你每隔一段时间，发送一些数据，那么sessionCreated()方法只会在第一次调用，但是sessionOpened()方法每次都会调用。
	 */
	@Override
	public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {

//		System.err.println("sessionOpened");
		super.sessionOpened(nextFilter, session);
	}

	/**
	 对于TCP 来说，连接被关闭时，调用这个方法。
	 对于UDP 来说，IoSession 的close()方法被调用时才会毁掉这个方法。
	 */
	@Override
	public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {


		InetSocketAddress clientSocket = (InetSocketAddress)session.getRemoteAddress();
		LOGGER.error("客户端关闭:{}", clientSocket.toString());
		
		try {
			cuckooNetPreserve(clientSocket, session);
		} catch (Exception e) {
			LOGGER.error("unknow error:{}", e.getMessage(), e);
		}
		
		try {
			runningJobBreakWhenSessionClosed(clientSocket, session);
		} catch (Exception e) {
			LOGGER.error("unknow error:{}", e.getMessage(), e);
		}
		

		super.sessionClosed(nextFilter, session);
	}

	/**
	 * 正在执行的任务，设置成断线
	 * @param session
	 */
	private void runningJobBreakWhenSessionClosed(InetSocketAddress clientSocket , IoSession session) {
		
		
		CuckooJobExecLogCriteria logCrt = new CuckooJobExecLogCriteria();
		logCrt.createCriteria().andCuckooClientIpEqualTo(clientSocket.getAddress().getHostAddress())
		.andCuckooClientPortEqualTo(clientSocket.getPort())
		.andExecJobStatusEqualTo(CuckooJobExecStatus.RUNNING.getValue());
		
		List<CuckooJobExecLog> logs = cuckooJobExecLogMapper.selectByExample(logCrt);
		if(CollectionUtils.isNotEmpty(logs)){
			for (CuckooJobExecLog cuckooJobExecLog : logs) {
				// 更新日志
				cuckooJobLogService.updateJobLogStatusById(cuckooJobExecLog.getId(), CuckooJobExecStatus.BREAK, "session closed!");
			}
		}
	}

	private void cuckooNetPreserve(InetSocketAddress clientSocket , IoSession session) {
		
		// 删除client数据
		CuckooNetClientInfoCriteria clientCrt = new CuckooNetClientInfoCriteria();
		clientCrt.createCriteria().andIpEqualTo(clientSocket.getAddress().getHostAddress())
		.andPortEqualTo(clientSocket.getPort());
		List<CuckooNetClientInfo> clientInfos = cuckooNetClientInfoMapper.selectByExample(clientCrt);
		
		if(CollectionUtils.isNotEmpty(clientInfos)){
			for (CuckooNetClientInfo cuckooNetClientInfo : clientInfos) {
				cuckooNetService.removeNetClient(cuckooNetClientInfo);
			}
		}
		
		
	
		JobClientSessionCache.remove(session);
	}

	/**
	 这个方法在IoSession 的通道进入空闲状态时调用，对于UDP 协议来说，这个方法始终不会被调用。
	 */
	@Override
	public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {

//		System.err.println("sessionIdle");
		super.sessionIdle(nextFilter, session, status);
	}
	
	

	
}
