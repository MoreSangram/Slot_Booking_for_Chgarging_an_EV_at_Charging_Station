package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	@Autowired
	 private  JavaMailSender emailSender;

	 public  void sendEmailForNewRegistration(String email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
      message.setFrom("slotbooking3264@gmail.com");
      message.setTo(email); 
      message.setSubject("Thank you for Registering with us!"); 
      message.setText("Thank you for Registering with us!  Now you can book slot for your vehicle.");
      emailSender.send(message);
	 }

}
