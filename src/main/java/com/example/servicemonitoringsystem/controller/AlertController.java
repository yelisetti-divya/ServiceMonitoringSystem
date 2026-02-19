package com.example.servicemonitoringsystem.controller;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import com.example.servicemonitoringsystem.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/all")
    public List<AlertEntity> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
