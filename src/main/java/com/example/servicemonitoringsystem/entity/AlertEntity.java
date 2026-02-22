package com.example.servicemonitoringsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceId;
    private Long ruleId;
    private String message;
    private String status = "Live";
    private int count = 1;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime lastOccurrence = LocalDateTime.now();

    public AlertEntity() {}

    // Getters & Setters
    public Long getId() { return id; }
    public Long getServiceId() { return serviceId; }
    public Long getRuleId() { return ruleId; }
    public String getMessage() { return message; }
    public String getStatus() { return status; }
    public int getCount() { return count; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getLastOccurrence() { return lastOccurrence; }

    public void setId(Long id) { this.id = id; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setRuleId(Long ruleId) { this.ruleId = ruleId; }
    public void setMessage(String message) { this.message = message; }
    public void setStatus(String status) { this.status = status; }
    public void setCount(int count) { this.count = count; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setLastOccurrence(LocalDateTime lastOccurrence) { this.lastOccurrence = lastOccurrence; }
}