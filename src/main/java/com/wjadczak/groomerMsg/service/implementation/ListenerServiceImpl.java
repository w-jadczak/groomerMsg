package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.service.ListenerService;
import com.wjadczak.groomerMsg.service.MessageBuilderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.yaml")
public class ListenerServiceImpl implements ListenerService {

    private final MessageBuilderService messageBuilderService;
    private final MessageSenderServiceImpl messageSenderService;
    @Override
    @RabbitListener(queues = "${spring.rabbitmq.registrationQueue}")
    public void onUserRegistration(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) throws MessagingException {
        log.info("User registration event received", notificationDto);
        MessageEntity message = messageBuilderService.buildAndSaveMessage(notificationDto);
        messageSenderService.sendEmail(message);
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.appointmentCancellationQueue}")
    public void onAppointmentCancellation(NotificationDto notificationDto) throws MessagingException {
        log.info("Appointment cancellation event received", notificationDto);
        MessageEntity message = messageBuilderService.buildAndSaveMessage(notificationDto);
        messageSenderService.sendEmail(message);
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.appointmentConfirmationQueue}")
    public void onAppointmentConfirmation(NotificationDto notificationDto) throws MessagingException {
        log.info("Appointment confirmation event received", notificationDto);
        MessageEntity message = messageBuilderService.buildAndSaveMessage(notificationDto);
        messageSenderService.sendEmail(message);
    }
}
