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


    // Delete a project by its ID
    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }
}