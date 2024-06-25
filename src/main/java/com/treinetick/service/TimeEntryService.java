package com.treinetick.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinetick.model.TimeEntry;
import com.treinetick.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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

    public TimeEntry createTimeEntry(TimeEntry timeEntry) {
        timeEntry.setCreatedAt(new Date());
        return timeEntryRepository.save(timeEntry);
    }

    public Optional<TimeEntry> updateEndTime(String id, String endTimeJson) {
        Optional<TimeEntry> timeEntryOpt = timeEntryRepository.findById(id);
        if (timeEntryOpt.isPresent()) {
            TimeEntry timeEntry = timeEntryOpt.get();

            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(endTimeJson);
                String endTimeString = jsonNode.get("timeEnd").asText();

                Instant instant = Instant.parse(endTimeString);
                Date endTimeDate = Date.from(instant);

                timeEntry.setTimeEnd(endTimeDate);
                timeEntry.setUpdatedAt(new Date());
                return Optional.of(timeEntryRepository.save(timeEntry));
            } catch (Exception e) {
                // Log the error and return empty Optional
                e.printStackTrace();
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
