package com.wjadczak.groomerMsg.controller;

import com.wjadczak.groomerMsg.dto.MessageDto;
import com.wjadczak.groomerMsg.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(
            summary = "Get messages by event date",
            description = "Returns messages for a specific event date",
            parameters = {@Parameter(
                    name = "eventDate",
                    description = "Event date in format yyyy-MM-ddTHH:mm:ss",
                    example = "2024-05-07T15:30:00"
            )},
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @GetMapping("/message/event/{eventDate}")
    public ResponseEntity<List<MessageDto>> getMessagesByEventDate(@RequestParam LocalDateTime eventDate) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getMessagesByEventDate(eventDate));
    }

    @Operation(
            summary = "Get messages by receiver email",
            description = "Returns messages for a specific receiver email",
            parameters = {@Parameter(
                    name = "receiverEmail",
                    description = "Receiver's email address",
                    example = "example@example.com"
            )},
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @GetMapping("/message/receiver")
    public ResponseEntity<List<MessageDto>> getMessagesByReceiverEmail(@RequestParam String receiverEmail) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getMessagesByReceiverEmail(receiverEmail));
    }

    @Operation(
            summary = "Get all messages",
            description = "Returns all messages",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @GetMapping("/message")
    public ResponseEntity<List<MessageDto>> getAllMessages() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getAllMessages());
    }
}

