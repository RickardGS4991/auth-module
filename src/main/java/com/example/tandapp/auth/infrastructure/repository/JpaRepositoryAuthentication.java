package com.example.tandapp.auth.infrastructure.repository;
import com.example.tandapp.auth.infrastructure.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRepositoryAuthentication extends JpaRepository<UsersEntity, UUID> {
    void saveUsers(UsersEntity users);
}
