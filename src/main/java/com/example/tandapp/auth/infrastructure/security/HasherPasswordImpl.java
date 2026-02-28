package com.example.tandapp.auth.infrastructure.security;

import com.example.tandapp.auth.domain.ports.out.IHasherPassword;
import com.example.tandapp.auth.domain.exceptions.InformationInvalidateException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HasherPasswordImpl implements IHasherPassword {

    private final BCryptPasswordEncoder encoder;

    public HasherPasswordImpl(){
        this.encoder = new BCryptPasswordEncoder(10);
    }

    @Override
    public String hasherPassword(String password) {
        if(password == null || password.isBlank()) throw new InformationInvalidateException("password");

        return encoder.encode(password);
    }

    @Override
    public boolean matchesPassword(String rawPassword, String hashedPassword){
        if(rawPassword == null || hashedPassword == null) return false;
        return encoder.matches(rawPassword, hashedPassword);
    }
}
