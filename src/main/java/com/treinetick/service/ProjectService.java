package com.treinetick.service;


import com.treinetick.model.Project;
import com.treinetick.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Get a project by its ID
    public Optional<Project> getProjectById(String projectId) {
        return projectRepository.findById(projectId);
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Update an existing project
    public Project updateProject(String projectId, Project projectDetails) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setProjectName(projectDetails.getProjectName());
            project.setDescription(projectDetails.getDescription());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            project.setStatus(projectDetails.getStatus());
            project.setUserId(projectDetails.getUserId());
            project.setClientId(projectDetails.getClientId());
            project.setCreatedAt(projectDetails.getCreatedAt());
            project.setUpdatedAt(projectDetails.getUpdatedAt());
            return projectRepository.save(project);
        } else {
            throw new RuntimeException("Project not found with id " + projectId);
        }
    }

    // Delete a project by its ID
    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }
}