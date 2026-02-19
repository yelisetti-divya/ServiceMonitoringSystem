package com.example.servicemonitoringsystem.repository;

import com.example.servicemonitoringsystem.entity.MetricsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricsRepository extends JpaRepository<MetricsEntity, Long> {
}
