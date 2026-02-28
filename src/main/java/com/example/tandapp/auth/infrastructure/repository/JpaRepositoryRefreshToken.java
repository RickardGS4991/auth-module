package com.example.tandapp.auth.infrastructure.repository;

import com.example.tandapp.auth.infrastructure.entities.RefreshTokensEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRepositoryRefreshToken extends JpaRepository<RefreshTokensEntity, UUID> {
}
