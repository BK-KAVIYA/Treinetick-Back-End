package com.treinetick.controller;



import com.treinetick.model.TimeEntry;
import com.treinetick.service.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    @DeleteMapping("/{id}")
    public void deleteTimeEntry(@PathVariable String id) {
        timeEntryService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<TimeEntry> createTimeEntry(@RequestBody TimeEntry timeEntry) {
        timeEntry.setCreatedAt(new Date());
        TimeEntry createdTimeEntry = timeEntryService.createTimeEntry(timeEntry);
        return ResponseEntity.ok(createdTimeEntry);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TimeEntry> updateEndTime(@PathVariable String id, @RequestBody String endTime) throws ParseException, ParseException {
        Optional<TimeEntry> updatedTimeEntry = timeEntryService.updateEndTime(id, endTime);
        return updatedTimeEntry.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

