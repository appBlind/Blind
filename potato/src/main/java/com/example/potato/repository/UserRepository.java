package com.example.potato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.potato.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a User by email
    Optional<User> findByEmail(String email);
}
