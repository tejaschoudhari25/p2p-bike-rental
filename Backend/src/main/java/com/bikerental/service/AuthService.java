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
            request.getEmail(),
            request.getPassword(),
            request.getFirstName(),
            request.getLastName(),
            request.getRole() != null ? request.getRole() : "ROLE_USER"
        );
        userRepository.save(user);
    }
}
