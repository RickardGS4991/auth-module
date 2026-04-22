package com.example.authServiceT.auth.domain.ports.out;

import com.example.authServiceT.auth.domain.Users;

import java.util.Optional;

public interface IUserRepository {
    void save(Users registerUserRequest);
    Optional<Users> confirmCredentials(String email);
}
