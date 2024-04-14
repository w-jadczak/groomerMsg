package com.wjadczak.groomerMsg.service.factory;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;

public class BookingConfirmationFactory implements MessageFactory{
    @Override
    public MessageEntity createMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        MessageEntity confirmationMessage = MessageEntity
                .builder()
                .type(notificationDto.getType())
                .receiverEmail(notificationDto.getReceiverMail())
                .subject("Booking confirmation.")
                .body("Your appointment from " + notificationDto.getEventDate() + " was confirmed.")
                .eventDate(notificationDto.getEventDate())
                .messageStatus(MessageStatus.PROCESSING)
                .build();
        return confirmationMessage;
    }
}
