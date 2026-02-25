package com.example.servicemonitoringsystem.entity;

import jakarta.persistence.*;

@Entity
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metric;     // responseTime, failureCount, CPU, etc.
    private String operator;   // >, <, >=, <=, ==
    private double value;      // threshold

    public Long getId() {
        return id;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}