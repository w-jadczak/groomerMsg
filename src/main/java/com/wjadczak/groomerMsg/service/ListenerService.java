package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.dto.NotificationDto;

public interface ListenerService {
    void onUserRegistration(NotificationDto notificationDto);
    void onAppointmentCancellation(NotificationDto notificationDto);
    void onAppointmentConfirmation(NotificationDto notificationDto);
}
