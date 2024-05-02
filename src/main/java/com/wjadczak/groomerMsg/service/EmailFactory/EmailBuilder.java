package com.wjadczak.groomerMsg.service.EmailFactory;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

public interface EmailBuilder {
    MimeMessage buildEmail(MessageEntity messageEntity, JavaMailSender mailSender, TemplateEngine templateEngine) throws MessagingException;
}
