package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.entity.MessageEntity;

public interface MessageBuilderService {
    public MessageEntity buildAndSaveMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto);
}
