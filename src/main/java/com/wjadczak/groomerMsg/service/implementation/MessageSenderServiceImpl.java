package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;
import com.wjadczak.groomerMsg.repository.MessageRepository;
import com.wjadczak.groomerMsg.service.EmailFactory.EmailBuilder;
import com.wjadczak.groomerMsg.service.EmailFactory.EmailBuilderFactory;
import com.wjadczak.groomerMsg.service.MessageSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageSenderServiceImpl implements MessageSenderService {
    private final JavaMailSender mailSender;
    private final MessageRepository messageRepository;
    private final TemplateEngine templateEngine;
    @Override
    public void sendEmail(MessageEntity messageEntity) throws MessagingException {

        EmailBuilder emailBuilder = EmailBuilderFactory.createBuilder(messageEntity.getType());
        if(emailBuilder == null){
            throw new IllegalArgumentException("Invalid email type: " + messageEntity.getType());
        }

        MimeMessage message = emailBuilder.buildEmail(messageEntity, mailSender,templateEngine);

        mailSender.send(message);
        messageEntity.setMessageStatus(MessageStatus.SENT);
        messageRepository.save(messageEntity);
        log.info("message sent to: " + messageEntity.getReceiverEmail());
    }

}
