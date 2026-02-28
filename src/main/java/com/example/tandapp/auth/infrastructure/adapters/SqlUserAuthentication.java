package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.ports.out.IUserRepository;
import com.example.tandapp.auth.infrastructure.entities.UsersEntity;
import com.example.tandapp.auth.infrastructure.mappers.UserMapper;
import com.example.tandapp.auth.infrastructure.repository.JpaRepositoryAuthentication;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class SqlUserAuthentication implements IUserRepository {
    private final JpaRepositoryAuthentication jpaRepositoryAuthentication;
    private final UserMapper userMapper;

    public SqlUserAuthentication(JpaRepositoryAuthentication jpaRepositoryAuthentication, UserMapper userMapper) {
        this.jpaRepositoryAuthentication = jpaRepositoryAuthentication;
        this.userMapper = userMapper;
    }

    @Override
    public void save(Users user) {
        UsersEntity newMember = userMapper.toPersistance(user);
        jpaRepositoryAuthentication.save(newMember);
    }

    @Override
    public Optional<Users> confirmCredentials(String email){
        return Optional.ofNullable(jpaRepositoryAuthentication.findByInformationEmail(email)).map(userMapper::toDomain);
    }
}
