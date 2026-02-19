package com.example.servicemonitoringsystem.controller;

import com.example.servicemonitoringsystem.entity.ServiceEntity;
import com.example.servicemonitoringsystem.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/register")
    public String registerService(@RequestBody ServiceEntity service) {
        serviceService.registerService(service);
        return "Service Registered Successfully!";
    }

    @GetMapping("/all")
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }
}
