package com.example.servicemonitoringsystem.service;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import com.example.servicemonitoringsystem.entity.MetricsEntity;
import com.example.servicemonitoringsystem.repository.AlertRepository;
import com.example.servicemonitoringsystem.repository.MetricsRepository;
import org.springframework.stereotype.Service;

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
        if (metrics.getResponseTime() > 300) {
            AlertEntity alert = new AlertEntity();
            alert.setServiceId(metrics.getServiceId());
            alert.setMessage("High response time for service ID " + metrics.getServiceId());
            alertRepository.save(alert);
        }

        // Rule 2: High failure count
        if (metrics.getFailureCount() > 5) {
            AlertEntity alert = new AlertEntity();
            alert.setServiceId(metrics.getServiceId());
            alert.setMessage("High failure count for service ID " + metrics.getServiceId());
            alertRepository.save(alert);
        }

        return saved;
    }
}
