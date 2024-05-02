package com.wjadczak.groomerMsg.dto;

import com.wjadczak.groomerMsg.enums.MessageStatus;
import com.wjadczak.groomerMsg.enums.MessageType;

import java.time.LocalDateTime;

public class MessageDto {

    private MessageType type;
    private String receiverEmail;
    private MessageStatus messageStatus;
    private LocalDateTime eventDate;
    private LocalDateTime sendDate;

}
