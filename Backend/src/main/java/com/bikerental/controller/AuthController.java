package com.bikerental.controller;

import com.bikerental.dto.request.RegisterRequest;
import com.bikerental.entity.User;
// import com.bikerental.repository.UserRepository;
import com.bikerental.service.AuthService;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    // private final UserRepository userRepository;
    
    @Autowired
    private AuthService authService;

    // AuthController(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

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

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> li = authService.getAllUsersList();
        return ResponseEntity.ok(li); 
        // return authService.getAllUsersList();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User u = authService.getUserById(id);
        return ResponseEntity.ok(u);
        // return authService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        authService.deleteUserById(id);
        return ResponseEntity.ok("deleted the user");
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    User user = authService.updateUser(id, updatedUser);
    return ResponseEntity.ok(user);
}
    

    // @GetMapping("/login")
    // public String login(@RequestBody RegisterRequest request) {
    //     System.out.println("LOGIN API HIT ✅");
    //     // authService.login(request);
    //     return "User logged in successfully ✅";
    // }
}