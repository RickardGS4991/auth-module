package com.example.tandapp.auth.controller;

import com.example.tandapp.auth.application.dto.LoginUserResponse;
import com.example.tandapp.auth.application.ports.in.ILoginUseCase;
import com.example.tandapp.auth.application.ports.in.IRefreshAccessTokenUseCase;
import com.example.tandapp.auth.application.ports.in.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.core.utils.entity.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authentication {

    private final IRegisterUseCase register;
    private final ILoginUseCase login;
    private final IRefreshAccessTokenUseCase refreshAccessToken;

    public Authentication(IRegisterUseCase register, ILoginUseCase login, IRefreshAccessTokenUseCase refreshAccessToken) {
        this.register = register;
        this.login = login;
        this.refreshAccessToken = refreshAccessToken;
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

    @GetMapping("/refresh")
    public ResponseEntity<ApiResponse<String>> refreshing(@Valid @RequestParam(name = "token") String refreshToken){
        String newAccessToken = refreshAccessToken.execute(refreshToken);

        return ResponseEntity.status(201).body(new ApiResponse<String>("New token", true, newAccessToken));
    }
}
