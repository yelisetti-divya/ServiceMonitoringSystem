package com.example.servicemonitoringsystem.service;

import com.example.servicemonitoringsystem.entity.Rule;
import com.example.servicemonitoringsystem.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleEngineService {

    @Autowired
    private RuleRepository ruleRepository;

    public boolean evaluateMetric(String metricName, double metricValue) {

        List<Rule> rules = ruleRepository.findAll();

        for (Rule rule : rules) {

            if (!rule.getMetric().equals(metricName)) continue;

            if (applyRule(rule, metricValue)) {
                return true;  // alert triggered
            }
        }
        return false;
    }

    private boolean applyRule(Rule rule, double currentValue) {

        switch (rule.getOperator()) {
            case ">":  return currentValue > rule.getValue();
            case "<":  return currentValue < rule.getValue();
            case ">=": return currentValue >= rule.getValue();
            case "<=": return currentValue <= rule.getValue();
            case "==": return currentValue == rule.getValue();
            default:   return false;
        }
    }
}