package com.example.servicemonitoringsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/secure-data")
    public String secureData() {
        return "You accessed a PROTECTED API successfully!";
    }
}