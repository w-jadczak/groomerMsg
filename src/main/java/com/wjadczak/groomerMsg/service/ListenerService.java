package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import jakarta.mail.MessagingException;

public interface ListenerService {
    void onUserRegistration(NotificationDto notificationDto) throws MessagingException;
    void onAppointmentCancellation(NotificationDto notificationDto) throws MessagingException;
    void onAppointmentConfirmation(NotificationDto notificationDto) throws MessagingException;
}
