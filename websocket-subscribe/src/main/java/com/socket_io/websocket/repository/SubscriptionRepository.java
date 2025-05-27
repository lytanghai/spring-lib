package com.socket_io.websocket.repository;

import com.socket_io.websocket.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByUserIdAndAdminId(String userId, String adminId);
    void deleteByUserIdAndAdminId(String userId, String adminId);
    List<Subscription> findByUserId(String userId);
}
