package com.example.authServiceT.auth.application.ports.out;

public interface IEmailCheckRepository {
    boolean checkEmail(String email);
}
