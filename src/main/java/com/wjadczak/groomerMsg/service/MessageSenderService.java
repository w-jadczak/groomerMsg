package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import jakarta.mail.MessagingException;

public interface MessageSenderService {
    void sendEmail(MessageEntity messageEntity) throws MessagingException;
}
