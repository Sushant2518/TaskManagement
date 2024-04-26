package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.masai.entity.Task;
import com.masai.entity.User;
import com.masai.exception.TaskNotFoundException;
import com.masai.exception.UserException;
import com.masai.repository.TaskRepo;
import com.masai.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service

public class TaskServiceImpl implements TasksService{

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        // Set other fields as needed

        return taskRepo.save(task);
    }

    public Task markTaskAsCompleted(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(true);

        return taskRepo.save(task);
    }

    public Task assignTaskToUser( Long taskId, String username) {
        Optional<Task> task = taskRepo.findById(taskId);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }

        // Find the user by username
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) {
            throw new UserException("User not found");
        }

        task.get().setUser(user.get());
        return task.get();
    }

}
