package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.entity.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/find-user/{username}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String username){
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.CREATED);
    }
}
