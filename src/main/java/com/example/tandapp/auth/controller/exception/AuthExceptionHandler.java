package com.example.tandapp.auth.controller.exception;

import com.example.tandapp.auth.domain.exceptions.IncorrectAccessException;
import com.example.tandapp.auth.domain.exceptions.InformationAlreadyEnteredException;
import com.example.tandapp.auth.domain.exceptions.InformationInvalidateException;
import com.example.tandapp.utils.entity.ApiResponse;
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
        return ResponseEntity.status(500).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }

    @ExceptionHandler(IncorrectAccessException.class)
    public ResponseEntity<ApiResponse<Void>> incorrectInformationHandler(IncorrectAccessException ex){
        return ResponseEntity.status(408).body(new ApiResponse<Void>(ex.getMessage(), false, null));
    }
}
