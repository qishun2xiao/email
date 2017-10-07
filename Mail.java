package com.grace527.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: Mail
 * @Description: 邮件转发系统核心类
 * @author wuqishun
 * @date 2017年10月7日
 */
public class Mail extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息  收件人  主题  正文
		try {
			String name = request.getParameter("m-name");
			String top = request.getParameter("m-topci");
			String con = request.getParameter("m-con");
			//用户信息   用户名  密码
			String userName = "2490702388@qq.com";
            String passWord = "xqhdahvozeodecbb";
			//邮箱属性  邮件协议
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.transport.protocol", "smtp");
			prop.put("mail.smtp.host", "smtp.qq.com");
			prop.put("mail.smtp.port", "587");
		    // 构建授权信息，用于进行SMTP进行身份验证
	        Authenticator authenticator = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // 用户名、密码
	                String userName = "2490702388@qq.com";
	                String passWord = "xqhdahvozeodecbb";
	                return new PasswordAuthentication(userName, passWord);
	            }
	        };
			//创建一个邮箱
			Session session = Session.getInstance(prop,authenticator);
			session.setDebug(true);
			MimeMessage ms = new MimeMessage(session);
			//设置邮箱来源
			InternetAddress toAddress;
			toAddress = new InternetAddress(userName);
			ms.setFrom(toAddress);
			//邮件的接收者
			ms.setRecipients(Message.RecipientType.TO, "qishun2xiao@126.com");
			top ="来件人(个人邮件转发系统 )："+top;
			ms.setSubject(top);
			ms.setText(con);
			ms.saveChanges();//保存
			//创建发送工具
			Transport ts = session.getTransport();
			ts.connect(userName,passWord);
			ts.sendMessage(ms, ms.getAllRecipients());
			ts.close();
			//Transport.send(ms);
			PrintWriter pw = response.getWriter();
			pw.print("发送成功~~");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
