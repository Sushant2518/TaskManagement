package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.entity.Task;
import com.masai.service.TasksService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TasksService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails) {
        return new ResponseEntity<>(taskService.updateTask(taskId, taskDetails),HttpStatus.OK);
    }

    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.markTaskAsCompleted(taskId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{taskId}/assign/{username}")
    public ResponseEntity<Task> assignTaskToUser(@PathVariable Long taskId, @PathVariable String username) {
        return new ResponseEntity<>(taskService.assignTaskToUser(taskId,username),HttpStatus.OK);
    }
}

