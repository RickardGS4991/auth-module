package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.repository.IUserAuth;
import com.example.tandapp.auth.infrastructure.entities.UsersEntity;
import com.example.tandapp.auth.infrastructure.mappers.UserMapper;
import com.example.tandapp.auth.infrastructure.repository.JpaRepositoryAuthentication;
import org.springframework.stereotype.Component;

@Component
public class SqlUserAuthImpl implements IUserAuth {

    private final JpaRepositoryAuthentication jpaRepositoryAuthentication;
    private final UserMapper userMapper;

    public SqlUserAuthImpl(JpaRepositoryAuthentication jpaRepositoryAuthentication, UserMapper userMapper) {
        this.jpaRepositoryAuthentication = jpaRepositoryAuthentication;
        this.userMapper = userMapper;
    }

    @Override
    public void save(Users user) {

        UsersEntity newMember = userMapper.toPersistance(user);

        jpaRepositoryAuthentication.save(newMember);
    }
}
