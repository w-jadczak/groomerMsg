package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.dto.NotificationDto;

public interface ListenerService {
    public NotificationDto onUserRegistration(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto);
}
