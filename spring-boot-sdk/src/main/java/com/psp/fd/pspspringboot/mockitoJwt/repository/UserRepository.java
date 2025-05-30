package com.psp.fd.pspspringboot.mockitoJwt.repository;

import com.psp.fd.pspspringboot.mockitoJwt.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
