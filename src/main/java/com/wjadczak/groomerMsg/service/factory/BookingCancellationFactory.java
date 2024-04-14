package com.wjadczak.groomerMsg.service.factory;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;

public class BookingCancellationFactory implements MessageFactory{
    @Override
    public MessageEntity createMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        MessageEntity cancellationMessage = MessageEntity
                .builder()
                .type(notificationDto.getType())
                .receiverEmail(notificationDto.getReceiverMail())
                .subject("Booking cancellation.")
                .body("Your appointment from " + notificationDto.getEventDate() + " was cancelled.")
                .eventDate(notificationDto.getEventDate())
                .messageStatus(MessageStatus.PROCESSING)
                .build();
        return cancellationMessage;
    }
}
