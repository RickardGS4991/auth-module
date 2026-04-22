package com.example.authServiceT.auth.application.ports.in;

public interface ILogOutUseCase {
    void execute(String refreshToken);
}
