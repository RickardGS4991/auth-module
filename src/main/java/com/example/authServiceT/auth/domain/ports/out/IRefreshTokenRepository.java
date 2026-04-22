package com.example.authServiceT.auth.domain.ports.out;

import com.example.authServiceT.auth.domain.RefreshTokens;

import java.util.Optional;

public interface IRefreshTokenRepository {
    void save(RefreshTokens token);
    Optional<RefreshTokens> findByToken(String token);
    void deleteByRefreshToken(String refreshToken);
}
