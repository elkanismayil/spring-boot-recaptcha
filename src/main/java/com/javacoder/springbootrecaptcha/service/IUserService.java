package com.javacoder.springbootrecaptcha.service;

import com.javacoder.springbootrecaptcha.entity.User;

import java.util.List;

public interface IUserService {
    Integer createUser(User user);

    List<User> getAllUsers();
}
