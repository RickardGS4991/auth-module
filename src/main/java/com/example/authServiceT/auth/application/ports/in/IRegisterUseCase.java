package com.example.authServiceT.auth.application.ports.in;

import com.example.authServiceT.auth.application.dto.RegisterUserRequest;

public interface IRegisterUseCase {
    void execute(RegisterUserRequest information);
}
