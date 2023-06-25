package com.example.Task_manager.controller;

import com.example.Task_manager.model.Users;
import com.example.Task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users users) {
        if (userRepository.findByEmail(users.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        Users savedUser = userRepository.save(users);
        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users users) {
        Users storedUser = userRepository.findByEmail(users.getEmail());
        if (storedUser != null && storedUser.getPassword().equals(users.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}
