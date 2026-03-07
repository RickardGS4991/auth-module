package com.example.tandapp.core.utils.entity;

public record ApiResponse<T>(String message, boolean success, T data) {}
