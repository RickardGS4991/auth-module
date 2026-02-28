package com.example.tandapp.auth.application.ports.in;

import com.example.tandapp.auth.application.dto.RegisterUserRequest;

public interface IRegisterUseCase {
    void execute(RegisterUserRequest information);
}
