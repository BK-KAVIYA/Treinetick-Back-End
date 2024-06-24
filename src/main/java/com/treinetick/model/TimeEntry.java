package com.treinetick.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "TimeEntry")
public class TimeEntry {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "timeEntryID", nullable = false)
    private String timeEntryId;

    @Column(name = "task_ID", nullable = false)
    private Integer taskId;

    @Column(name = "timeSpent", precision = 5)
    private Double timeSpent;

    @Column(name = "entryDate")
    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @Column(name = "createdAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "updateAt")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_Id", insertable = false, updatable = false)
    private User user;

    // Getters and Setters

    public String getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(String timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(Integer userId) {
        this.user = user;
    }

    public Double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

