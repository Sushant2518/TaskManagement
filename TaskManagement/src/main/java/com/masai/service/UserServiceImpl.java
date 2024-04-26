package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepo userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UserException("User does not exist with this username"));
    }

    public User createUser(User user) {
        if (findByUsername(user.getUsername()) != null) {
            throw new UserException("Username already exists");
        }

      return userRepository.save(user);
    }
}
