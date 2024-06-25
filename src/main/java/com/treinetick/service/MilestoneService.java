package com.treinetick.service;


import com.treinetick.model.Milestone;
import com.treinetick.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    @Autowired
    public MilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public List<Milestone> findAll() {
        return milestoneRepository.findAll();
    }

    public Optional<Milestone> findById(String id) {
        return milestoneRepository.findById(id);
    }

    public Milestone save(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    public void deleteById(String id) {
        milestoneRepository.deleteById(id);
    }
}

