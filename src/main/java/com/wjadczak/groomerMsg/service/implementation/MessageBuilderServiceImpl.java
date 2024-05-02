package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;
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
        MessageEntity messageEntity = createMessageFromDto(notificationDto);
        messageRepository.save(messageEntity);
        return messageEntity;
    }

    private MessageEntity createMessageFromDto(com.wjadczak.groomerMsg.dto.NotificationDto notificationDto) {
        MessageEntity message = MessageEntity
                .builder()
                .type(notificationDto.getType())
                .receiverEmail(notificationDto.getReceiverMail())
                .eventDate(notificationDto.getEventDate())
                .messageStatus(MessageStatus.PROCESSING)
                .build();
        return message;
    }
}
