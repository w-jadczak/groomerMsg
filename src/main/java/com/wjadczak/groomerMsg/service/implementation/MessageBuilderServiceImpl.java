package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageType;
import com.wjadczak.groomerMsg.repository.MessageRepository;
import com.wjadczak.groomerMsg.service.MessageBuilderService;
import com.wjadczak.groomerMsg.service.factory.BookingCancellationFactory;
import com.wjadczak.groomerMsg.service.factory.BookingConfirmationFactory;
import com.wjadczak.groomerMsg.service.factory.MessageFactory;
import com.wjadczak.groomerMsg.service.factory.RegistrationConfirmationFactory;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageBuilderServiceImpl implements MessageBuilderService {
    private final Map<MessageType, MessageFactory> messageFactoryMap;
    private final MessageRepository messageRepository;

    public MessageBuilderServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        messageFactoryMap = new HashMap<>();
        messageFactoryMap.put(MessageType.REGISTRATION_CONFIRMATION, new RegistrationConfirmationFactory());
        messageFactoryMap.put(MessageType.BOOKING_CONFIRMATION, new BookingConfirmationFactory());
        messageFactoryMap.put(MessageType.BOOKING_CANCELLATION, new BookingCancellationFactory());
    }

    @Override
    public MessageEntity buildAndSaveMessage(@Valid NotificationDto notificationDto) {
        MessageType messageType = notificationDto.getType();
        MessageFactory messageFactory = messageFactoryMap.get(messageType);
        MessageEntity messageEntity = messageFactory.createMessage(notificationDto);
        messageRepository.save(messageEntity);
        return messageEntity;
    }
}
