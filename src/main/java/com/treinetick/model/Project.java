package com.treinetick.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "projectID", nullable = false)
    private String projectId;

    @Column(name = "projectName", length = 75)
    private String projectName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "user_ID", length = 255)
    private String userId;

    @Column(name = "client_ID", length = 45)
    private String clientId;

    @Column(name = "createdAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "updateAt")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id",referencedColumnName = "projectID")
    private Set<Task>taskList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id",referencedColumnName = "projectID")
    private Set<Milestone>milestonesList;

//    @OneToMany(mappedBy = "project")
//    private Set<Task> taskSet;

    // Getters and Setters

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
