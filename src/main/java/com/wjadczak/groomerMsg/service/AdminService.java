package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.dto.MessageDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {

    List<MessageDto> getMessagesByEventDate(LocalDateTime eventDate);
    List<MessageDto> getAllMessages();
    List<MessageDto> getMessagesByReceiverEmail(String email);
}
