package com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final int PORT;

    @Autowired
    public EmailService(JavaMailSender mailSender, @Value("${server.port}") int port){
        this.mailSender = mailSender;
        this.PORT = port;
    }

    public void sendActivationEmail(String email, String token){
        String activationLink = "http://localhost:" + PORT + "/api/auth/activate?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Activate your account");
        message.setText("Click the link to activate your account: " + activationLink);

        mailSender.send(message);
    }
}
