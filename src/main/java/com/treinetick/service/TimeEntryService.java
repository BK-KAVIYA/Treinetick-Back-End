package com.treinetick.service;

import com.treinetick.model.TimeEntry;
import com.treinetick.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryService(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public List<TimeEntry> findAll() {
        return timeEntryRepository.findAll();
    }

    public Optional<TimeEntry> findById(String id) {
        return timeEntryRepository.findById(id);
    }

    public TimeEntry save(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    public void deleteById(String id) {
        timeEntryRepository.deleteById(id);
    }
}
