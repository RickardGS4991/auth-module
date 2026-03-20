package com.example.tandapp.auth.infrastructure.repository;

import com.example.tandapp.auth.infrastructure.entities.RefreshTokensEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaRepositoryRefreshToken extends JpaRepository<RefreshTokensEntity, UUID> {
    Optional<RefreshTokensEntity> findByRefreshToken(String token);
    @Transactional
    void deleteByRefreshToken(String token);
}
