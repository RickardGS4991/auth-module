package com.example.tandapp.auth.domain.repository;

import com.example.tandapp.auth.domain.Users;

public interface IRegisterUseCase {
    void save(Users user);
}
