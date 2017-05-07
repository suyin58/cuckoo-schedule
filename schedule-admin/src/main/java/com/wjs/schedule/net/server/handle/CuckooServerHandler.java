package com.wjs.schedule.net.server.handle;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wjs.schedule.bean.ClientTaskInfoBean;
import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.bean.MessageInfo;
import com.wjs.schedule.component.cuckoo.CuckooJobCallBack;
import com.wjs.schedule.enums.CuckooMessageType;
import com.wjs.schedule.service.net.CuckooNetService;

/**
 * 服务器端业务逻辑，封装TimeServerHander，需要针对客户端的session进行缓存操作，并记录数据库
 */
public class CuckooServerHandler extends IoHandlerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooServerHandler.class);
	
	final Gson  gson = new GsonBuilder().create();
	
	@Autowired
	CuckooNetService cuckooServerService;
	
	@Autowired
	CuckooJobCallBack cuckooJobCallBack;
	
	
    
    /**
     * 消息接收事件
     * 接收到消息时调用的方法，也就是用于接收消息的方法，一般情况下，message 是一个IoBuffer 类，
     * 如果你使用了协议编解码器，那么可以强制转换为你需要的类型。
     * 通常我们都是会使用协议编解码器的， 就像上面的例子， 因为协议编解码器是TextLineCodecFactory，所以我们可以强制转message 为String 类型。
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
    	

        String strMsg = message.toString();
        // 心跳信息
        if(CuckooMessageType.HEARTBEATCLIENT.getValue().equals(strMsg)){

            // 打印客户端传来的消息内容
            LOGGER.info("Server Received HEARTBEATCLIENT : " + strMsg);
        	return;
        }
        // 打印客户端传来的消息内容
        LOGGER.info("Server Received Message : " + strMsg);
        
        MessageInfo msgInfo = null;
        try {
        	msgInfo = gson.fromJson(strMsg, MessageInfo.class);
		} catch (Exception e) {
			LOGGER.error("cuckoo server can not read message:{}", strMsg , e);
			return;
		}
        
        if(CuckooMessageType.REGIST.getValue().equals(msgInfo.getMessageType().getValue())){
        	// 客户端任务注册.  {"messageType":"REGIST","message":{"appName":"member","beanName":"cuckooTestTaskImpl","methodName":"testJob","taskName":"testJob"}}
        	ClientTaskInfoBean taskInfo = gson.fromJson(gson.toJson(msgInfo.getMessage()), ClientTaskInfoBean.class);
        	cuckooServerService.addRemote(session, taskInfo);
        } else if(CuckooMessageType.JOBSUCCED.getValue().equals(msgInfo.getMessageType().getValue())){
        	// 客户端任务执行成功 .  {"messageType":"JOBSUCCED","message":{"jobName":"testJob2","txDate":20160101,"forceJob":false,"needTrigglerNext":true,"cuckooParallelJobArgs":""}}
        	JobInfoBean jobInfo = gson.fromJson(gson.toJson(msgInfo.getMessage()), JobInfoBean.class);
        	cuckooJobCallBack.execJobSuccedCallBack(jobInfo);
        } else if(CuckooMessageType.JOBFAILED.getValue().equals(msgInfo.getMessageType().getValue())){
        	// 客户端任务执行失败.  {"messageType":"JOBFAILED","message":{"jobName":"testJob2","txDate":20160101,"forceJob":false,"needTrigglerNext":true,"cuckooParallelJobArgs":""}}
        	JobInfoBean jobInfo = gson.fromJson(gson.toJson(msgInfo.getMessage()), JobInfoBean.class);
        	cuckooJobCallBack.execJobFailedCallBack(jobInfo);
        } else{
        	LOGGER.error("cuckoo server get a unknow message type{}", strMsg);
        }
        
    }

    /**
     * 当发送消息成功时调用这个方法，注意这里的措辞，发送成功之后，也就是说发送消息是不能用这个方法的。
	     发送消息的时机： 发送消息应该在sessionOpened()、messageReceived()方法中调用IoSession.write()方法完成。
	     因为在sessionOpened()方法中，TCP 连接已经真正打开，同样的在messageReceived()方法TCP 连接也是打开状态，只不过两者的时机不同。
	  sessionOpened()方法是在TCP 连接建立之后，接收到数据之前发送；
	  messageReceived()方法是在接收到数据之后发送，你可以完成依据收到的内容是什么样子，决定发送什么样的数据。因为这个接口中的方法太多，因此通常使用适配器模式IoHandlerAdapter，覆盖你所感兴趣的方法即可。
     */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		
		super.messageSent(session, message);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		
		super.exceptionCaught(session, cause);
	}
	
	
	
    
    
}