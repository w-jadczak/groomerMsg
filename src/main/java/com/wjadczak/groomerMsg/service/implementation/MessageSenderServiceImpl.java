package com.wjadczak.groomerMsg.service.implementation;

import com.wjadczak.groomerMsg.service.MessageBuilderService;
import com.wjadczak.groomerMsg.service.MessageSenderService;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MessageSenderServiceImpl implements MessageSenderService {
    private final JavaMailSender mailSender;
    private final MessageBuilderService messageBuilderService;
    @Override
    public void sendEmail() {

    }
}
