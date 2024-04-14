package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.service.ListenerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class ListenerServiceImpl implements ListenerService {

    private final RabbitTemplate rabbitTemplate;
    @Override
    @RabbitListener(queues = "q.user_registration")
    public NotificationDto onUserRegistration(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        log.info("User registration event received", notificationDto);
        return notificationDto;
    }
}
