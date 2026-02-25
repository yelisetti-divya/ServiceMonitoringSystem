package com.example.servicemonitoringsystem.controller;

import com.example.servicemonitoringsystem.service.JwtService;
import com.example.servicemonitoringsystem.entity.User;
import com.example.servicemonitoringsystem.repository.UserRepository;
import com.example.servicemonitoringsystem.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Registered Successfully!";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return Map.of("error", "User not found!");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return Map.of("error", "Invalid password!");
        }

        String token = jwtService.generateToken(user.getUsername());

        return Map.of("token", token);
    }
}