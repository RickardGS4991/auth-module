package com.example.authServiceT.auth.infrastructure.mappers;

import com.example.authServiceT.auth.domain.RefreshTokens;
import com.example.authServiceT.auth.infrastructure.entities.RefreshTokensEntity;
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
