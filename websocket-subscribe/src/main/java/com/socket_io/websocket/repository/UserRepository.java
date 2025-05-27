package com.socket_io.websocket.repository;

import com.socket_io.websocket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
