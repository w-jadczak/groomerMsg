package com.wjadczak.groomerMsg.entity;

import com.wjadczak.groomerMsg.enums.MessageStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    private UUID id;
    private String title;
    private String subject;
    private String body;
    private String receiverMail;
    private MessageStatus messageStatus;
    private LocalDateTime sendDate;
    @Lob
    private byte[] attachement;

}
