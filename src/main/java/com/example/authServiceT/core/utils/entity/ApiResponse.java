package com.example.authServiceT.core.utils.entity;

public record ApiResponse<T>(String message, boolean success, T data) {}
