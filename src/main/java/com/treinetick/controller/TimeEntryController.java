package com.treinetick.controller;



import com.treinetick.model.TimeEntry;
import com.treinetick.service.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    @Autowired
    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @GetMapping
    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TimeEntry> getTimeEntryById(@PathVariable String id) {
        return timeEntryService.findById(id);
    }

    @PostMapping
    public TimeEntry createTimeEntry(@RequestBody TimeEntry timeEntry) {
        return timeEntryService.save(timeEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeEntry(@PathVariable String id) {
        timeEntryService.deleteById(id);
    }
}

