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

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        Optional<User> existing =
                userRepository.findAll()
                        .stream()
                        .filter(u -> u.getEmail().equals(user.getEmail()))
                        .findFirst();

        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> existing =
                userRepository.findAll()
                        .stream()
                        .filter(u ->
                                u.getEmail().equals(user.getEmail()) &&
                                u.getPassword().equals(user.getPassword()))
                        .findFirst();

        return existing.isPresent()
                ? "Login successful"
                : "Invalid email or password";
    }
}
