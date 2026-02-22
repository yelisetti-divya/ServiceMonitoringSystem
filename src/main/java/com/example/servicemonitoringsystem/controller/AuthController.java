package com.example.servicemonitoringsystem.controller;
import com.example.servicemonitoringsystem.service.JwtService;

import com.example.servicemonitoringsystem.entity.User;
import com.example.servicemonitoringsystem.repository.UserRepository;
import com.example.servicemonitoringsystem.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public String login(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return "User not found!";
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid password!";
        }

        // Generate JWT Token
        return jwtService.generateToken(user.getUsername());
    }
}