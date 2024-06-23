package com.treinetick.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "ActivityLog")
public class ActivityLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "logID", nullable = false)
    private String logId;


    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;

    @Column(name = "action", length = 255)
    private String action;

    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "task_ID", length = 255)
    private String taskId;


    // Getters and Setters

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}

