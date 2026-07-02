package com.bikerental.service;

import com.bikerental.dto.request.RegisterRequest;
import com.bikerental.entity.User;
import com.bikerental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void register(RegisterRequest request) {
        User user = new User(
            request.email,
            request.password,
            request.firstName,
            request.lastName,
            request.role != null ? request.role : "ROLE_USER"
        );
        userRepository.save(user);
    }
}
