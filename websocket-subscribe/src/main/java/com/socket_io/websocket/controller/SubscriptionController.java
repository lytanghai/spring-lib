package com.socket_io.websocket.controller;

import com.socket_io.websocket.model.Admin;
import com.socket_io.websocket.model.Subscription;
import com.socket_io.websocket.model.User;
import com.socket_io.websocket.repository.AdminRepository;
import com.socket_io.websocket.repository.SubscriptionRepository;
import com.socket_io.websocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired private SubscriptionRepository subscriptionRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private AdminRepository adminRepo;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestParam String userId, @RequestParam String adminId) {
        if (subscriptionRepo.existsByUserIdAndAdminId(userId, adminId)) {
            return ResponseEntity.badRequest().body("Already subscribed");
        }

        User user = userRepo.findById(userId).orElseGet(() -> userRepo.save(new User(userId, "User-" + userId)));
        Admin admin = adminRepo.findById(adminId).orElseGet(() -> adminRepo.save(new Admin(adminId, "Admin-" + adminId)));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setAdmin(admin);
        subscriptionRepo.save(subscription);

        return ResponseEntity.ok("Subscribed");
    }

    @PostMapping("/unsubscribe")
    @Transactional // Add this annotation
    public ResponseEntity<?> unsubscribe(@RequestParam String userId, @RequestParam String adminId) {
        subscriptionRepo.deleteByUserIdAndAdminId(userId, adminId);
        return ResponseEntity.ok("Unsubscribed");
    }
}
