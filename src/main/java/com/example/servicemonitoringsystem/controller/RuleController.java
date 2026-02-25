package com.example.servicemonitoringsystem.controller;

import com.example.servicemonitoringsystem.entity.Rule;
import com.example.servicemonitoringsystem.repository.RuleRepository;
import com.example.servicemonitoringsystem.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private RuleEngineService ruleEngineService;

    @GetMapping("/add")
    public String info() {
        return "Use POST /rules/add with JSON body to add a rule";
    }

    @PostMapping("/add")
    public String addRule(@RequestBody Rule rule) {
        ruleRepository.save(rule);
        return "Rule Added Successfully!";
    }

    @GetMapping("/all")
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // Evaluate rule dynamically
    @PostMapping("/evaluate")
    public boolean evaluateMetric(@RequestBody Map<String, Object> body) {

        String metric = body.get("metric").toString();
        double value = Double.parseDouble(body.get("value").toString());

        return ruleEngineService.evaluateMetric(metric, value);
    }
}