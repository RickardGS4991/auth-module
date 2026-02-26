package com.example.tandapp.auth.infrastructure.repository;

import com.example.tandapp.auth.infrastructure.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRepositoryCheckEmail extends JpaRepository<UsersEntity, UUID> {
    boolean existsByEmail(String email);
}
