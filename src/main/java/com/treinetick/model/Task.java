package com.treinetick.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "taskID", nullable = false, length = 255)
    private String taskId;

    @Column(name = "content", length = 100)
    private String content;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "Priority", length = 45)
    private String priority;

    @Column(name = "createDateAndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateAndTime;

    @Column(name = "updatedAt")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "tag", length = 45)
    private String tag;

    @Column(name = "user_ID_createBy", length = 255)
    private String userIdCreateBy;

    @Column(name = "user_ID_assignBy", length = 255)
    private String userIdAssignBy;

    @Column(name = "project_ID", length = 255)
    private String projectId;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id",referencedColumnName = "taskID")
    private Set<Comment> commentList;
    // Getters and Setters

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getCreateDateAndTime() {
        return createDateAndTime;
    }

    public void setCreateDateAndTime(Date createDateAndTime) {
        this.createDateAndTime = createDateAndTime;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUserIdCreateBy() {
        return userIdCreateBy;
    }

    public void setUserIdCreateBy(String userIdCreateBy) {
        this.userIdCreateBy = userIdCreateBy;
    }

    public String getUserIdAssignBy() {
        return userIdAssignBy;
    }

    public void setUserIdAssignBy(String userIdAssignBy) {
        this.userIdAssignBy = userIdAssignBy;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}

