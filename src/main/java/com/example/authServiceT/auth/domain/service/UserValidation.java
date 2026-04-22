package com.example.authServiceT.auth.domain.service;

import com.example.authServiceT.auth.domain.Users;
import com.example.authServiceT.auth.domain.exceptions.IncorrectAccessException;
import com.example.authServiceT.auth.application.ports.out.IEmailCheckRepository;
import com.example.authServiceT.auth.domain.ports.out.IHasherPassword;
import com.example.authServiceT.auth.domain.ports.out.IUserRepository;

public class UserValidation {

    private final IEmailCheckRepository emailCheckRepository;
    private final IUserRepository getUserInformation;
    private final IHasherPassword hasherPassword;

    public UserValidation(IEmailCheckRepository emailCheckRepository, IUserRepository getUserInformation, IHasherPassword hasherPassword) {
        this.emailCheckRepository = emailCheckRepository;
        this.getUserInformation = getUserInformation;
        this.hasherPassword = hasherPassword;
    }

    public boolean verifyEmail(String email){
        return emailCheckRepository.checkEmail(email);
    }

    public Users getUserInformation(String email, String rawPassword){
        Users info = getUserInformation.confirmCredentials(email).orElseThrow(IncorrectAccessException::new);

        if(!hasherPassword.matchesPassword(rawPassword, info.getInformation().getPassword())){
            throw new IncorrectAccessException();
        }

        return info;
    }
}
