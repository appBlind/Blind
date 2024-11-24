package com.example.potato.controller;

import com.example.potato.dto.ApiResponse;
import com.example.potato.dto.LoginRequest;
import com.example.potato.model.User;
import com.example.potato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody User user) {
        Optional<User> existingUser = userService.findUserByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, "Email already in use"));
        }
        userService.registerUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "User registered successfully!"));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.findUserByEmail(loginRequest.getEmail());

        if (user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity.ok(new ApiResponse(true, "Login successful!"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(false, "Invalid email or password"));
    }

    // 사용자 삭제 (DELETE /api/users/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}