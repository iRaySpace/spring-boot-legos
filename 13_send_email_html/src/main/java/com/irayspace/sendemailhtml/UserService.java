package com.irayspace.sendemailhtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public String resetPassword(ResetPasswordRequest request) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("hello@irayspace.com");
        helper.setTo(request.getEmail());
        helper.setSubject("Reset your password");

        Context context = new Context();
        context.setVariable("email", request.getEmail());
        helper.setText(templateEngine.process("reset.html", context), true);

        javaMailSender.send(message);

        return "Email sent successfully!";
    }
}
