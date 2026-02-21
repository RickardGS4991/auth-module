package com.example.tandapp.utils.entity;

public record ApiResponse<T>(String message, boolean success, T data) {}
