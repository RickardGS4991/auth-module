package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.RefreshTokens;

import java.util.Optional;

public interface IRefreshTokenRepository {
    void save(RefreshTokens token);
    Optional<RefreshTokens> findByToken(String token);
}
