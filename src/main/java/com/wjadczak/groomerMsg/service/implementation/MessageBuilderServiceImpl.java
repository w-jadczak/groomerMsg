package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;
import com.wjadczak.groomerMsg.enums.MessageType;
import com.wjadczak.groomerMsg.repository.MessageRepository;
import com.wjadczak.groomerMsg.service.MessageBuilderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MessageBuilderServiceImpl implements MessageBuilderService {
    private final MessageRepository messageRepository;
    @Override
    public MessageEntity buildAndSaveMessage(@Valid NotificationDto notificationDto) {
        MessageType messageType = notificationDto.getType();
        MessageEntity messageEntity = createMessage(notificationDto);
        messageRepository.save(messageEntity);
        return messageEntity;
    }

    private MessageEntity createMessage(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        MessageEntity confirmationMessage = MessageEntity
                .builder()
                .type(notificationDto.getType())
                .receiverEmail(notificationDto.getReceiverMail())
                .eventDate(notificationDto.getEventDate())
                .messageStatus(MessageStatus.PROCESSING)
                .build();
        return confirmationMessage;
    }
}
