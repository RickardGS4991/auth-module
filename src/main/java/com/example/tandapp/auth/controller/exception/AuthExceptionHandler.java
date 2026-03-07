package com.example.tandapp.auth.controller.exception;

import com.example.tandapp.auth.domain.exceptions.*;
import com.example.tandapp.core.utils.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(InformationAlreadyEnteredException.class)
    public ResponseEntity<ApiResponse<Void>> handleInformationAlreadyEntered(InformationAlreadyEnteredException ex){
        return ResponseEntity.status(409).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(InformationInvalidateException.class)
    public ResponseEntity<ApiResponse<Void>> informationInvalidateResponse(InformationInvalidateException ex){
        return ResponseEntity.status(400).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(IncorrectAccessException.class)
    public ResponseEntity<ApiResponse<Void>> incorrectInformationHandler(IncorrectAccessException ex){
        return ResponseEntity.status(401).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(RefreshTokenExpired.class)
    public ResponseEntity<ApiResponse<Void>> refreshTokenExpired(RefreshTokenExpired ex){
        return ResponseEntity.status(401).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(InvalidAccessToken.class)
    public ResponseEntity<ApiResponse<Void>> invalidAccessToken(InvalidAccessToken ex){
        return ResponseEntity.status(401).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(RefreshTokenNotFound.class)
    public ResponseEntity<ApiResponse<Void>> refreshTokenNotFound(RefreshTokenNotFound ex){
        return ResponseEntity.status(401).body(new ApiResponse<>(ex.getMessage(), false, null));
    }
}
