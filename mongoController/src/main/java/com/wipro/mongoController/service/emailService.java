package com.wipro.mongoController.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

@Service
public class emailService {
	
	String message= "testing, hacked by trishit";
	String subject= "hacking test";
	String to= "trishit.das10@gmail.com";
	String from= "trishitd42@gmail.com";
	
	public static void sendEmail(String message, String subject, String to, String from) {
		
		Properties properties= System.getProperties();
		
		//setting information to prop obj
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//1) getting session obj
		javax.mail.Session session= javax.mail.Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("trishitd42@gmail.com","Trishit@1999");
			}
			
		});
		session.setDebug(true);
		
		//2) compose the message
		MimeMessage mime=new MimeMessage(session);
		
		//3) from which email
		try {
			
			
		//from where mssg will be sent
		mime.setFrom(from);
		
		
		// setting the recipient
		
		mime.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//setting subject
		mime.setSubject(subject);
		
		//setting text which will be sent to recipient
		mime.setText(message);
		
		//all setting done
		//now we need to send the message using transport class
		
		Transport.send(mime);
		
		
		}
		catch (Exception e) {
			e.printStackTrace(); //used to print the trace from where exception is coming
		}
		
			
	}
}
