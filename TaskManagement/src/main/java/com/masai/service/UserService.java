package com.masai.service;

import com.masai.entity.User;

public interface UserService {

    User findByUsername(String username);

    User createUser(User user);

}
