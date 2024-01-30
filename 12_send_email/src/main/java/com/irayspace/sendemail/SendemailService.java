package com.irayspace.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendemailService {
    @Autowired
    private JavaMailSender emailSender;

    @Value("${app.mail.from}")
    private String from;

    public void send(SendemailRequest data) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(data.getEmail());
        message.setSubject("Hello from Spring Boot");
        message.setText("Hello, this is a test email.");
        emailSender.send(message);
    }
}
