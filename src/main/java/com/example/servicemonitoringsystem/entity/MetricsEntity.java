package com.example.servicemonitoringsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "metrics")
public class MetricsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceId;
    private int responseTime;
    private int failureCount;

    public MetricsEntity() {}

    public Long getId() { return id; }
    public Long getServiceId() { return serviceId; }
    public int getResponseTime() { return responseTime; }
    public int getFailureCount() { return failureCount; }

    public void setId(Long id) { this.id = id; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setResponseTime(int responseTime) { this.responseTime = responseTime; }
    public void setFailureCount(int failureCount) { this.failureCount = failureCount; }
}
