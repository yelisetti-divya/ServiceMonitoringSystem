package com.example.servicemonitoringsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricService {

    @Autowired
    private RuleEngineService ruleEngineService;

    public void processMetrics(double responseTime, int failureCount) {

        if (ruleEngineService.evaluateMetric("responseTime", responseTime)) {
            System.out.println("⚠ Alert: Response Time Rule Triggered");
        }

        if (ruleEngineService.evaluateMetric("failureCount", failureCount)) {
            System.out.println("⚠ Alert: Failure Count Rule Triggered");
        }
    }
}