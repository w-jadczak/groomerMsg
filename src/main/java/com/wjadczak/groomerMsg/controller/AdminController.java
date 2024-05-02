package com.wjadczak.groomerMsg.controller;

import com.wjadczak.groomerMsg.dto.MessageDto;
import com.wjadczak.groomerMsg.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/message/{eventDate}")
    public ResponseEntity<List<MessageDto>> getMessagesByEventDate(@RequestParam LocalDateTime eventDate) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getMessagesByEventDate(eventDate));
    }

    @GetMapping("/message/{receiverEmail}")
    public ResponseEntity<List<MessageDto>> getMessagesByReceiverEmail(@RequestParam String receiverEmail) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getMessagesByReceiverEmail(receiverEmail));
    }

    @GetMapping("/message")
    public ResponseEntity<List<MessageDto>> getMessagesByEventDate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getAllMessages());
    }
}
