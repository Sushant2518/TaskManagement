package com.masai.service;

import java.util.List;

import com.masai.entity.Task;

public interface TasksService {


    List<Task> getAllTasks() ;

    Task createTask(Task task) ;

    Task updateTask(Long taskId, Task taskDetails) ;

   Task markTaskAsCompleted(Long taskId);

    Task assignTaskToUser( Long taskId, String username);
}
