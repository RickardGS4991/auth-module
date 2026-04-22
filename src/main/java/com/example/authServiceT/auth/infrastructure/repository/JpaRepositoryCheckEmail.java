package com.example.authServiceT.auth.infrastructure.repository;

import com.example.authServiceT.auth.infrastructure.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaRepositoryCheckEmail extends JpaRepository<UsersEntity, UUID> {
    boolean existsByInformationEmail(String email);
}
