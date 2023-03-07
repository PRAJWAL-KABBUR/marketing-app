package com.marketing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component    // This can also be made @Service layer but can't made @Controler layer 
public class EmailSericeImpl implements EmailService {

	@Autowired 
	private JavaMailSender javaMailSender;   // JavaMailSender is an interface 
	
	@Override
	public void sendEmail(String to, String sub, String msg) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();  // SimpleMailMessage is class
		
		mailMessage.setTo(to);
		mailMessage.setSubject(sub);
		mailMessage.setText(msg); // 3 methods to create message
		
		javaMailSender.send(mailMessage); 
		
	}

}
