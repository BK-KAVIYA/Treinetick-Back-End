package com.treinetick.controller;

import com.treinetick.model.ActivityLog;
import com.treinetick.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activity-logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @Autowired
    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ActivityLog> getActivityLogById(@PathVariable String id) {
        return activityLogService.findById(id);
    }

    @PostMapping
    public ActivityLog createActivityLog(@RequestBody ActivityLog activityLog) {
        return activityLogService.save(activityLog);
    }

    @DeleteMapping("/{id}")
    public void deleteActivityLog(@PathVariable String id) {
        activityLogService.deleteById(id);
    }
}

