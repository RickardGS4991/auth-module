package com.example.tandapp.auth.domain.service;

import com.example.tandapp.auth.domain.repository.IEmailCheckRepository;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    private IEmailCheckRepository emailCheckRepository;

    public UserValidation(IEmailCheckRepository emailCheckRepository) {
        this.emailCheckRepository = emailCheckRepository;
    }
    public boolean verifyEmail(String email){
        return emailCheckRepository.checkEmail(email);
    }
}
