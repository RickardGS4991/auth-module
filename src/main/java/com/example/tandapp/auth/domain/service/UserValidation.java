package com.example.tandapp.auth.domain.service;

import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    public boolean verifyEmail(String email){
        return true;
    }
}
