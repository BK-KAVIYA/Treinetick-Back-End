package com.treinetick.service;

import com.treinetick.model.ActivityLog;
import com.treinetick.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public List<ActivityLog> findAll() {
        return activityLogRepository.findAll();
    }

    public Optional<ActivityLog> findById(String id) {
        return activityLogRepository.findById(id);
    }

    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    public void deleteById(String id) {
        activityLogRepository.deleteById(id);
    }
}

