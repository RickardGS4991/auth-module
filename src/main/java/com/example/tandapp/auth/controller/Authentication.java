package com.example.tandapp.auth.controller;

import com.example.tandapp.auth.application.ports.in.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentication {

    public IRegisterUseCase register;

    public Authentication(IRegisterUseCase register){
        this.register = register;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRequest information){
        register.execute(information);

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> loginUser(@Valid @RequestBody LoginUserRequest information){
        throw new IllegalArgumentException();
    }
}
