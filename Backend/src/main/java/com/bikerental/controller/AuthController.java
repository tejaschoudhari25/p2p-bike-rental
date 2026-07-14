package com.bikerental.controller;

import com.bikerental.dto.request.RegisterRequest;
import com.bikerental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("Auth service is running ✅");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            System.out.println("REGISTER API HIT ✅");
            System.out.println("Request: " + request.getEmail());
            authService.register(request);
            return ResponseEntity.ok("User registered successfully ✅");
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Registration failed: " + e.getMessage());
        }
    }

    // @GetMapping("/login")
    // public String login(@RequestBody RegisterRequest request) {
    //     System.out.println("LOGIN API HIT ✅");
    //     // authService.login(request);
    //     return "User logged in successfully ✅";
    // }
}