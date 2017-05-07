package com.wjs.schedule.manage;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.wjs.schedule.component.cuckoo.CuckooJobCallBack;
import com.wjs.schedule.component.quartz.QuartzManage;
import com.wjs.schedule.dao.net.CuckooNetServerInfoMapper;

public class CuckooContainerManager implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	QuartzManage quartzManage;

	@Autowired
	CuckooNetServerInfoMapper cuckooNetServerInfoMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooJobCallBack.class);

	public static void main(String[] args) {
		try {
			System.out.println(InetAddress.getLocalHost());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (event.getApplicationContext().getParent() == null) {
			// donothing
			LOGGER.info("项目启动完成");

//			try {
//				CuckooNetServerInfoCriteria crt = new CuckooNetServerInfoCriteria();
//				crt.createCriteria().andIpEqualTo(InetAddress.getLocalHost().getHostAddress())
//				.andPortEqualTo(ConfigUtil.getInteger(CuckooNetConstant.CUCKOO_SERVER_TCPPORT));
//				if(CollectionUtils.isEmpty(cuckooNetServerInfoMapper.selectByExample(crt))){
//					CuckooNetServerInfo cuckooNetServerInfo = new CuckooNetServerInfo();
//					cuckooNetServerInfo.setIp(InetAddress.getLocalHost().getHostAddress());
//					cuckooNetServerInfo.setPort(ConfigUtil.getInteger(CuckooNetConstant.CUCKOO_SERVER_TCPPORT));
//					cuckooNetServerInfo.setModifyDate(System.currentTimeMillis());
//					cuckooNetServerInfoMapper.insertSelective(cuckooNetServerInfo);
//				}
//			} catch (UnknownHostException e) {
//				LOGGER.error("get local Ip error:{}", e.getMessage(), e);
//			}

			quartzManage.addAutoJob();
		}
	}

}
