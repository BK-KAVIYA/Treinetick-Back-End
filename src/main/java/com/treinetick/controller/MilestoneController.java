package com.treinetick.controller;

import com.treinetick.model.Milestone;
import com.treinetick.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @Autowired
    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping
    public List<Milestone> getAllMilestones() {
        return milestoneService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Milestone> getMilestoneById(@PathVariable String id) {
        return milestoneService.findById(id);
    }

    @PostMapping
    public Milestone createMilestone(@RequestBody Milestone milestone) {
        return milestoneService.save(milestone);
    }

    @DeleteMapping("/{id}")
    public void deleteMilestone(@PathVariable String id) {
        milestoneService.deleteById(id);
    }
}

