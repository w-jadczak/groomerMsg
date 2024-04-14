package com.wjadczak.groomerMsg.service.factory;

import com.wjadczak.groomerMsg.entity.MessageEntity;

public interface MessageFactory {
    MessageEntity createMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto);
}
