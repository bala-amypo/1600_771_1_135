package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil =
            new JwtUtil("ThisIsAVerySecureSecretKeyForJwtDemo123456789", 3600000);

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        AuthResponse response = new AuthResponse();
        response.setEmail(request.getEmail());
        response.setUserId(1L);
        response.setRole("SUBSCRIBER");
        response.setToken(jwtUtil.generateToken(1L, request.getEmail(), "SUBSCRIBER"));
        return response;
    }
}
