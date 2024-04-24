package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.entity.MessageEntity;

public interface MessageBuilderService {
    MessageEntity buildAndSaveMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto);
}
