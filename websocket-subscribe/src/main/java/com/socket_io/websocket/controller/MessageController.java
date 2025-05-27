package com.socket_io.websocket.controller;

import com.socket_io.websocket.model.Admin;
import com.socket_io.websocket.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private AdminRepository adminRepo;

    public static class MessageDTO {
        public String adminId;
        public String content;
    }

    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO message) {
        Admin admin = adminRepo.findById(message.adminId).orElse(null);
        if (admin != null) {
            messagingTemplate.convertAndSend("/topic/admin-" + admin.getId(), message);
        }
    }
}
