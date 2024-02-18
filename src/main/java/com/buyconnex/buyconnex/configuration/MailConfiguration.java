package com.buyconnex.buyconnex.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;



@Configuration
public class MailConfiguration {
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private int port;
	
	@Value("${spring.mail.debug}")
	private String debug;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String auth;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String tlsActif;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);
		Properties proper = mailSender.getJavaMailProperties();
		if(auth.equalsIgnoreCase("true")) {
			mailSender.setUsername(username);
			mailSender.setPassword(password);
			proper.put("mail.smtp.auth", "true");
			proper.put("mail.smtp.starttls.enable", tlsActif);
		}
		proper.put("mail.debug", debug);
		return mailSender;
	}
}
