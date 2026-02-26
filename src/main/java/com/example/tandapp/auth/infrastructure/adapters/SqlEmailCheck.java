package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.repository.IEmailCheckRepository;
import com.example.tandapp.auth.infrastructure.repository.JpaRepositoryCheckEmail;

public class SqlEmailCheck implements IEmailCheckRepository {
    JpaRepositoryCheckEmail repository;

    public SqlEmailCheck(JpaRepositoryCheckEmail repository) {
        this.repository = repository;
    }


    @Override
    public boolean checkEmail(String email) {
        return repository.existsByEmail(email);
    }
}
