package com.example.tandapp.domain.models;
import java.util.List;
import java.util.UUID;

public class Member {
    private final UUID id;
    private final String email;
    private String password;
    private MemberInformation information;

    public Member(UUID id, String email, String password, MemberInformation information) {
        if(email == null || password == null) throw new IllegalArgumentException("Email or password cannot be null");

        this.id = id;
        this.email = email;
        this.password = password;
        this.information = information;
    }

    public String getEmail(){
        return email;
    }

}
