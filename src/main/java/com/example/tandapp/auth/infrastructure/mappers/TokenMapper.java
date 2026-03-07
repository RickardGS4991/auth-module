package com.example.tandapp.auth.infrastructure.mappers;

import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.infrastructure.entities.RefreshTokensEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {
    public RefreshTokensEntity toPersistance(RefreshTokens token){
        return new RefreshTokensEntity(token.showRefreshTokenId(), token.getUserId(), token.getEmail(), token.showRToken(), token.getExpiresAt(), token.isRevoked());
    }

    public RefreshTokens toDomain(RefreshTokensEntity token){
        return RefreshTokens.restore(token.getRefreshTokenId(), token.getUserId(), token.getRefreshToken(), token.getEmail(), token.getExpiresAt(), token.getRevokedState());
    }
}
