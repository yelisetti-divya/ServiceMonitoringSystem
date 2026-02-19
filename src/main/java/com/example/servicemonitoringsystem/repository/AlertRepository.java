package com.example.servicemonitoringsystem.repository;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
}
