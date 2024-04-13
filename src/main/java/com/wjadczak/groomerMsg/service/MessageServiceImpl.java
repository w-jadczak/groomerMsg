package com.wjadczak.groomerMsg.service;

import com.wjadczak.groomerMsg.dto.MessageDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    private final JavaMailSender mailSender;
    @Override
    public void sendEmail() {

    }

    private MessageEntity buildEmail(MessageDto messageDto){
        return null;
    }
}
