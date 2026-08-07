package com.bikerental.service;

import com.bikerental.dto.request.LoginRequest;
import com.bikerental.dto.request.RegisterRequest;
import com.bikerental.entity.User;
import com.bikerental.repository.UserRepository;

import java.util.List;
// import java.util.Optional;

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

    // @Override
    public List<User> getAllUsersList(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }

    // public User loginUser(String email, String password){

    // }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login Successful";
    }
}
