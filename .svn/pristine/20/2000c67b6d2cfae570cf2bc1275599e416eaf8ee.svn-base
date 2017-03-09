package com.astrolink.util.tools;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.util.tools.javaMail.MailSenderInfo;
import com.astrolink.util.tools.javaMail.SimpleMailSender;

public class Email {
	public static Logger logger = null;
	public boolean pushInfo(int pushMode,ArrayList<String> toAddress, String text) {
		logger = Logger.getLogger(this.getClass());
		boolean type=false;
		try {
			for(String address:toAddress){
				logger.info(address+":"+text);
				switch (pushMode) {
				case 0://邮件
					MailSenderInfo mailInfo = new MailSenderInfo();
					mailInfo.setMailServerHost("smtp.139.com");
					mailInfo.setMailServerPort("25");
					mailInfo.setValidate(true);
					mailInfo.setUserName("18810766798@139.com");
					mailInfo.setPassword("seny9069");// 您的邮箱密码
					mailInfo.setFromAddress("18810766798@139.com");
					mailInfo.setToAddress(address);
					mailInfo.setSubject("警告：");
					mailInfo.setContent(text);
	
					// 这个类主要来发送邮件
					SimpleMailSender sms = new SimpleMailSender();
					sms.sendHtmlMail(mailInfo);// 发送文体格式
					type= true;
					break;
				case 1://短信
					type=false;
					break;
				default:
					type=false;
					break;
				}
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
			type=false;
		}
		return type;	
	}

}
