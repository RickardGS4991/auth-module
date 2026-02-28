package com.example.tandapp.auth.controller;

import com.example.tandapp.auth.application.dto.LoginUserResponse;
import com.example.tandapp.auth.application.ports.in.ILoginUseCase;
import com.example.tandapp.auth.application.ports.in.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.utils.entity.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentication {

    private final IRegisterUseCase register;
    private final ILoginUseCase login;

    public Authentication(IRegisterUseCase register, ILoginUseCase login){
        this.register = register;
        this.login = login;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRequest information){
        System.out.println("Entrando al controller");
        register.execute(information);

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<LoginUserResponse>> loginUser(@Valid @RequestBody LoginUserRequest information){
        LoginUserResponse responseLogin = login.execute(information);

        return ResponseEntity.status(200).body(new ApiResponse<LoginUserResponse>("Authenticated.", true, responseLogin));
    }
}
