package com.wjadczak.groomerMsg.service.EmailFactory;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
public class RegistrationConfirmationEmailBuilder implements EmailBuilder {
    @Override
    public MimeMessage buildEmail(MessageEntity messageEntity, JavaMailSender mailSender, TemplateEngine templateEngine) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(messageEntity.getReceiverEmail());
        messageHelper.setSubject("GroomerWebApp - Account registration.");
        messageHelper.setFrom("groomer.msg@onet.pl");

        Context context = new Context();
        context.setVariable("receiverEmail", messageEntity.getReceiverEmail());
        String processedString = templateEngine.process("registration_confirmation_email", context);
        messageHelper.setText(processedString, true);
        return message;
    }
}
