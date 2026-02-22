package com.example.servicemonitoringsystem.controller;

import com.example.servicemonitoringsystem.entity.MetricsEntity;
import com.example.servicemonitoringsystem.service.MetricsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @PostMapping("/send")
    public String sendMetrics(@RequestBody MetricsEntity metrics) {
        metricsService.saveMetrics(metrics);
        return "Metrics Saved & Rules Checked!";
    }
}