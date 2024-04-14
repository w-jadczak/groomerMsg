package com.wjadczak.groomerMsg.dto;

import com.wjadczak.groomerMsg.enums.MessageType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    @NotNull
    private MessageType type;
    @NotNull
    @Email
    private String receiverMail;
    @NotNull
    private LocalDateTime eventDate;
}
