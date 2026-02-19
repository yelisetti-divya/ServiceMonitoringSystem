package com.example.servicemonitoringsystem.repository;

import com.example.servicemonitoringsystem.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
