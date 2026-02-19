package com.example.servicemonitoringsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alerts")
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceId;
    private String message;

    public AlertEntity() {}

    public Long getId() { return id; }
    public Long getServiceId() { return serviceId; }
    public String getMessage() { return message; }

    public void setId(Long id) { this.id = id; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setMessage(String message) { this.message = message; }
}
