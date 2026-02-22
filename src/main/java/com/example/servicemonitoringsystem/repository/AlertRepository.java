package com.example.servicemonitoringsystem.repository;

import com.example.servicemonitoringsystem.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {

    @Query("SELECT a FROM AlertEntity a WHERE a.serviceId = :serviceId AND a.ruleId = :ruleId AND a.status = 'Live'")
    AlertEntity findLiveAlert(@Param("serviceId") Long serviceId, @Param("ruleId") Long ruleId);
}