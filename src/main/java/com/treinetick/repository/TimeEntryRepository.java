package com.treinetick.repository;

import com.treinetick.model.ActivityLog;
import com.treinetick.model.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, String> {

}

