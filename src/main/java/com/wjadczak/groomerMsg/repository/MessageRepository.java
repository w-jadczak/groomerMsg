package com.wjadczak.groomerMsg.repository;

import com.wjadczak.groomerMsg.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
    List<MessageEntity> findByReceiverEmail(String receiverEmail);
    List<MessageEntity> findByEventDate(LocalDateTime eventDate);
}
