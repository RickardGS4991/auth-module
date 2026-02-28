package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.Users;

import java.util.Optional;

public interface IUserRepository {
    void save(Users registerUserRequest);
    Optional<Users> confirmCredentials(String email);
}
