package com.example.tandapp.auth.domain.service;

import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.exceptions.IncorrectAccessException;
import com.example.tandapp.auth.application.ports.out.IEmailCheckRepository;
import com.example.tandapp.auth.domain.ports.out.IHasherPassword;
import com.example.tandapp.auth.domain.ports.out.IUserRepository;
import org.springframework.stereotype.Service;

@Service //Después se deberá crear un contenedor, para evitar tener una libreria externa en la capa de dominio
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
