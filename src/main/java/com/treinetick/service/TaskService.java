package com.treinetick.service;

import com.treinetick.model.Task;
import com.treinetick.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Read all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Read a task by ID
    public Optional<Task> getTaskById(String taskId) {
        return taskRepository.findById(taskId);
    }

    // Update a task
    public Task updateTask(String taskId, Task taskDetails) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setContent(taskDetails.getContent());
            task.setDescription(taskDetails.getDescription());
            task.setPriority(taskDetails.getPriority());
            task.setCreateDateAndTime(taskDetails.getCreateDateAndTime());
            task.setUpdatedAt(taskDetails.getUpdatedAt());
            task.setStatus(taskDetails.getStatus());
            task.setTag(taskDetails.getTag());
            task.setUserIdCreateBy(taskDetails.getUserIdCreateBy());
            task.setUserIdAssignBy(taskDetails.getUserIdAssignBy());
            task.setProjectId(taskDetails.getProjectId());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found with id " + taskId);
        }
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }
}
