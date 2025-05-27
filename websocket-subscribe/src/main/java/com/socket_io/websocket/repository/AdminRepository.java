package com.socket_io.websocket.repository;

import com.socket_io.websocket.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {}
