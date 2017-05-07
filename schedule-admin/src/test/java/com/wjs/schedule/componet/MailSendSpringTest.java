package com.wjs.schedule.componet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.ServiceUnitBaseTest;
import com.wjs.schedule.component.mail.MailSendSpring;

public class MailSendSpringTest extends ServiceUnitBaseTest{

	@Autowired
	MailSendSpring mailSendSpring;
	
	
	@Test
	public void testSend(){
		
		try {
			mailSendSpring.sendEmail("609061217@qq.com", "任务调度告警邮件", "测试内容");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
