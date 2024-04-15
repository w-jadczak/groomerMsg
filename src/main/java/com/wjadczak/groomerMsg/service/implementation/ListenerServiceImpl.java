package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.service.ListenerService;
import com.wjadczak.groomerMsg.service.MessageBuilderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerServiceImpl implements ListenerService {

    private final MessageBuilderService messageBuilderService;
    @Override
    @RabbitListener(queues = "q.user_registration")
    public void onUserRegistration(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        log.info("User registration event received", notificationDto);
        messageBuilderService.buildAndSaveMessage(notificationDto);
    }
}
