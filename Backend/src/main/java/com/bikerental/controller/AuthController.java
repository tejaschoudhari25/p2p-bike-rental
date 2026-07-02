package com.bikerental.controller;

import com.bikerental.dto.request.RegisterRequest;
import com.bikerental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        System.out.println("REGISTER API HIT ✅");
        authService.register(request);
        return "User registered successfully ✅";
    }

    // @GetMapping("/login")
    // public String login(@RequestBody RegisterRequest request) {
    //     System.out.println("LOGIN API HIT ✅");
    //     // authService.login(request);
    //     return "User logged in successfully ✅";
    // }
}