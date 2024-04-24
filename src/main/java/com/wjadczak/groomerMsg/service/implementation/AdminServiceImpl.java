package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.dto.MessageDto;
import com.wjadczak.groomerMsg.mapper.MessageEntityToDtoMapper;
import com.wjadczak.groomerMsg.repository.MessageRepository;
import com.wjadczak.groomerMsg.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final MessageRepository messageRepository;

    @Override
    public List<MessageDto> getMessagesByEventDate(LocalDateTime eventDate) {
        List<MessageDto> messages = MessageEntityToDtoMapper.
                messageEntityToDtoMapper
                .mapMessagesToDtos(messageRepository.findByEventDate(eventDate));
        return messages;
    }

    @Override
    public List<MessageDto> getAllMessages() {
        List<MessageDto> messages = MessageEntityToDtoMapper.
                messageEntityToDtoMapper
                .mapMessagesToDtos(messageRepository.findAll());
        return messages;
    }

    @Override
    public List<MessageDto> getMessagesByReceiverEmail(String email) {
        List<MessageDto> messages = MessageEntityToDtoMapper.
                messageEntityToDtoMapper
                .mapMessagesToDtos(messageRepository.findByReceiverEmail(email));
        return messages;
    }
}
