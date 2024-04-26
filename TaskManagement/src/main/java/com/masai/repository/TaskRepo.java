package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Task;
import com.masai.entity.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task,Long> {

    List<Task> findByUser(User user);
}
