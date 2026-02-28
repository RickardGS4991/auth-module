package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.RefreshTokens;

public interface IRefreshTokenRepository {
    void save(RefreshTokens token);
}
