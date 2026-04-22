package com.example.authServiceT.auth.infrastructure.adapters.persistance;

import com.example.authServiceT.auth.application.ports.out.IEmailCheckRepository;
import com.example.authServiceT.auth.infrastructure.repository.JpaRepositoryCheckEmail;
import org.springframework.stereotype.Repository;

@Repository
public class SqlEmailCheck implements IEmailCheckRepository {
    JpaRepositoryCheckEmail repository;

    public SqlEmailCheck(JpaRepositoryCheckEmail repository) {
        this.repository = repository;
    }


    @Override
    public boolean checkEmail(String email) {
        return repository.existsByInformationEmail(email);
    }
}
