package com.wjadczak.groomerMsg.entity;

import com.wjadczak.groomerMsg.enums.MessageStatus;
import com.wjadczak.groomerMsg.enums.MessageType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private MessageType type;
    @Column(name = "receiver_email")
    private String receiverEmail;
    @Enumerated(EnumType.STRING)
    @Column(name = "message_status")
    private MessageStatus messageStatus;
    @Column(name = "event_date")
    private LocalDateTime eventDate;
    @Column(name = "send_date")
    private LocalDateTime sendDate;
}
