package com.example.demo.config.controller;

import com.example.demo.config.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        Optional<User> existingUser =
                userRepository.findAll()
                        .stream()
                        .filter(u -> u.getEmail().equals(user.getEmail()))
                        .findFirst();

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    // LOGIN (PLAIN TEXT)
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> existingUser =
                userRepository.findAll()
                        .stream()
                        .filter(u ->
                                u.getEmail().equals(user.getEmail()) &&
                                u.getPassword().equals(user.getPassword()))
                        .findFirst();

        if (existingUser.isPresent()) {
            return "Login successful";
        }

        return "Invalid email or password";
    }
}
