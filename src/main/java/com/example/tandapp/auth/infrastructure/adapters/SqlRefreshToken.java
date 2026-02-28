package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.auth.infrastructure.entities.RefreshTokensEntity;
import com.example.tandapp.auth.infrastructure.mappers.TokenMapper;
import com.example.tandapp.auth.infrastructure.repository.JpaRepositoryRefreshToken;
import org.springframework.stereotype.Repository;

@Repository
public class SqlRefreshToken implements IRefreshTokenRepository {
    private final JpaRepositoryRefreshToken jpaRepositoryRefreshToken;
    private final TokenMapper mapper;

    public SqlRefreshToken(JpaRepositoryRefreshToken jpaRepositoryRefreshToken, TokenMapper mapper){
        this.jpaRepositoryRefreshToken = jpaRepositoryRefreshToken;
        this.mapper = mapper;
    }
    public void save(RefreshTokens token){
        RefreshTokensEntity refreshToken = mapper.toPersistance(token);
        jpaRepositoryRefreshToken.save(refreshToken);
    }
}
