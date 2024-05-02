package com.wjadczak.groomerMsg.unit;

import com.wjadczak.groomerMsg.dto.NotificationDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import com.wjadczak.groomerMsg.enums.MessageStatus;
import com.wjadczak.groomerMsg.enums.MessageType;
import com.wjadczak.groomerMsg.repository.MessageRepository;
import com.wjadczak.groomerMsg.service.implementation.MessageBuilderServiceImpl;
import com.wjadczak.groomerMsg.unit.config.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MessageBuilderServiceTest {
    @Mock
    private MessageRepository messageRepository;
    @InjectMocks
    private MessageBuilderServiceImpl messageBuilderService;

    @Test
    public void shouldReturmValidMessageEntityGivenValidDto() {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setType(MessageType.REGISTRATION_CONFIRMATION);
        notificationDto.setReceiverMail(TestUtils.TEST_EMAIL);
        notificationDto.setEventDate(TestUtils.FIXED_DATE_TIME);

        MessageEntity savedMessage = messageBuilderService.buildAndSaveMessage(notificationDto);

        assertEquals(MessageType.REGISTRATION_CONFIRMATION, savedMessage.getType());
        assertEquals(TestUtils.TEST_EMAIL, savedMessage.getReceiverEmail());
        assertEquals(MessageStatus.PROCESSING, savedMessage.getMessageStatus());

        ArgumentCaptor<MessageEntity> argumentCaptor = ArgumentCaptor.forClass(MessageEntity.class);
        verify(messageRepository).save(argumentCaptor.capture());
        MessageEntity capturedMessage = argumentCaptor.getValue();

        assertEquals(MessageType.REGISTRATION_CONFIRMATION, capturedMessage.getType());
        assertEquals(TestUtils.TEST_EMAIL, capturedMessage.getReceiverEmail());
        assertEquals(MessageStatus.PROCESSING, capturedMessage.getMessageStatus());
}
}
