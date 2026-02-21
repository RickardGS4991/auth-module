package com.example.tandapp.auth.application.base;

import com.example.tandapp.auth.application.dto.RegisterUserRequest;

public interface IRegisterUseCase {
    void execute(RegisterUserRequest information);
}
