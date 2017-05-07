package com.wjs.schedule.component.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.wjs.util.DateUtil;
import com.wjs.util.config.ConfigUtil;

@Component
public class MailSendSpring {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MailSendSpring.class);

	// 定义spring邮件发送
	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	@PostConstruct
	public void init() {
		Properties pro = System.getProperties(); // 下面各项缺一不可
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.ssl.enable", "true");
		pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		mailSender.setJavaMailProperties(pro);
		mailSender.setHost(ConfigUtil.get("email.send.host"));
		mailSender.setPassword(ConfigUtil.get("email.send.pwd"));
		mailSender.setUsername(ConfigUtil.get("email.send.email"));
		mailSender.setPort(ConfigUtil.getInteger("email.send.port"));
	}

	public boolean sendEmail(String mailTo, String title, String content) throws Exception {

		// 使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
		MimeMessage msg = mailSender.createMimeMessage();
		StringBuffer context = new StringBuffer("");

		try {
			// 创建MimeMessageHelper对象，处理MimeMessage的辅助类
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			// 使用辅助类MimeMessage设定参数
			helper.setTo(mailTo);
			helper.setSubject(title); // 主题：(邮件标题)
			InternetAddress from = new InternetAddress(ConfigUtil.get("email.send.email"),
					ConfigUtil.get("`.name"), "utf-8"); // 邮件地址、昵称
			helper.setFrom(from);

			// 设置收件人姓名+邮件发送日期+邮件样式+邮件内容
			String mailTemplateHeader = ConfigUtil.get("email.send.template.header"); // 邮件内容样式头
			String mailTemplateFooter = ConfigUtil.get("email.send.template.footer"); // 邮件内容样式脚
			mailTemplateHeader = mailTemplateHeader.replace("mailUserName", mailTo);
			mailTemplateFooter = mailTemplateFooter.replaceAll("mailSendDate", DateUtil.getStringDay(new Date()));
			context.append(mailTemplateHeader).append(content).append(mailTemplateFooter);

			// setText(),第二个参数true代表html
			helper.setText(context.toString(), true);

			// 附件
			// List<EmailAttach> emailAttachList = email.getEmailAttachList();
			// if (CollectionUtils.isNotEmpty(emailAttachList)) { //存在附件
			// for (EmailAttach emailAttach : emailAttachList) {
			// helper.addAttachment(emailAttach.getAttachName(), new
			// ByteArrayResource(IOUtils.toByteArray(inputStream)));
			// }
			// }

			// 发送邮件
			mailSender.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			throw new Exception("mail send error " + e.getMessage());
		}

		return true;
	}

}
