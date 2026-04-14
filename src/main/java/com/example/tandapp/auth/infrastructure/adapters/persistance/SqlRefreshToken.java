package com.example.tandapp.auth.infrastructure.adapters.persistance;

import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.auth.infrastructure.entities.RefreshTokensEntity;
import com.example.tandapp.auth.infrastructure.mappers.TokenMapper;
import com.example.tandapp.auth.infrastructure.repository.JpaRepositoryRefreshToken;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SqlRefreshToken implements IRefreshTokenRepository {
    private final JpaRepositoryRefreshToken jpaRepositoryRefreshToken;
    private final TokenMapper mapper;

    public SqlRefreshToken(JpaRepositoryRefreshToken jpaRepositoryRefreshToken, TokenMapper mapper){
        this.jpaRepositoryRefreshToken = jpaRepositoryRefreshToken;
        this.mapper = mapper;
    }


    @Override
    public void save(RefreshTokens token){
        RefreshTokensEntity refreshToken = mapper.toPersistance(token);
        jpaRepositoryRefreshToken.save(refreshToken);
    }

    @Override
    public Optional<RefreshTokens> findByToken(String token){
        return jpaRepositoryRefreshToken.findByRefreshToken(token).map(mapper::toDomain);
    }

    public void deleteByRefreshToken(String refreshToken){
        jpaRepositoryRefreshToken.deleteByRefreshToken(refreshToken);
    }
}
