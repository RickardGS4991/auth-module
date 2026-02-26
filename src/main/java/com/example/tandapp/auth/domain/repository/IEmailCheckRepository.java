package com.example.tandapp.auth.domain.repository;

import org.springframework.stereotype.Component;

@Component
public interface IEmailCheckRepository {
    boolean checkEmail(String email);
}
