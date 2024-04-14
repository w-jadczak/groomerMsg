package com.wjadczak.groomerMsg.service.factory;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;

public class RegistrationConfirmationFactory implements MessageFactory{
    @Override
    public MessageEntity createMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        MessageEntity registrationnMessage = MessageEntity
                .builder()
                .type(notificationDto.getType())
                .receiverEmail(notificationDto.getReceiverMail())
                .subject("GroomerWebApp registration confirmed.")
                .body("Your account was succesfully registered")
                .messageStatus(MessageStatus.PROCESSING)
                .build();
        return registrationnMessage;
    }
}
