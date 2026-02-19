package com.example.servicemonitoringsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    public ServiceEntity() {}

    public Long getId() { return id; }
    public String getServiceName() { return serviceName; }

    public void setId(Long id) { this.id = id; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
}
