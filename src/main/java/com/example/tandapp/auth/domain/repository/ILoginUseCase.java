package com.example.tandapp.auth.domain.repository;

import com.example.tandapp.auth.application.dto.LoginUserRequest;

public interface ILoginUseCase {
    void execute(LoginUserRequest info);
}
