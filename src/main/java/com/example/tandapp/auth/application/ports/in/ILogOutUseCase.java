package com.example.tandapp.auth.application.ports.in;

public interface ILogOutUseCase {
    void execute(String refreshToken);
}
