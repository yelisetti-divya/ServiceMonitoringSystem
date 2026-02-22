package com.example.servicemonitoringsystem.service;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import com.example.servicemonitoringsystem.entity.MetricsEntity;
import com.example.servicemonitoringsystem.repository.AlertRepository;
import com.example.servicemonitoringsystem.repository.MetricsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MetricsService {

    private final MetricsRepository metricsRepository;
    private final AlertRepository alertRepository;

    public MetricsService(MetricsRepository metricsRepository, AlertRepository alertRepository) {
        this.metricsRepository = metricsRepository;
        this.alertRepository = alertRepository;
    }

    public MetricsEntity saveMetrics(MetricsEntity metrics) {

        MetricsEntity saved = metricsRepository.save(metrics);

        // Rule 1: High response time
        createOrUpdateAlert(metrics.getServiceId(), 1L,
                "High response time for service ID " + metrics.getServiceId(),
                metrics.getResponseTime() > 300);

        // Rule 2: High failure count
        createOrUpdateAlert(metrics.getServiceId(), 2L,
                "High failure count for service ID " + metrics.getServiceId(),
                metrics.getFailureCount() > 5);

        return saved;
    }

    private void createOrUpdateAlert(Long serviceId, Long ruleId, String message, boolean condition) {
        if (!condition) return;

        AlertEntity existingAlert = alertRepository.findLiveAlert(serviceId, ruleId);

        if (existingAlert != null) {
            existingAlert.setCount(existingAlert.getCount() + 1);
            existingAlert.setLastOccurrence(LocalDateTime.now());
            alertRepository.save(existingAlert);
        } else {
            AlertEntity alert = new AlertEntity();
            alert.setServiceId(serviceId);
            alert.setRuleId(ruleId);
            alert.setMessage(message);
            alert.setStatus("Live");
            alert.setCount(1);
            alert.setCreatedAt(LocalDateTime.now());
            alert.setLastOccurrence(LocalDateTime.now());
            alertRepository.save(alert);
        }
    }
}