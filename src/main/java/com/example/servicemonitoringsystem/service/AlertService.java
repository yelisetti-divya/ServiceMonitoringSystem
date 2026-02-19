package com.example.servicemonitoringsystem.service;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import com.example.servicemonitoringsystem.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<AlertEntity> getAllAlerts() {
        return alertRepository.findAll();
    }
}
