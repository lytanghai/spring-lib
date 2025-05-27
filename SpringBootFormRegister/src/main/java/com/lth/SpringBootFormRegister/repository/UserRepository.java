package com.lth.SpringBootFormRegister.repository;

import com.lth.SpringBootFormRegister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
