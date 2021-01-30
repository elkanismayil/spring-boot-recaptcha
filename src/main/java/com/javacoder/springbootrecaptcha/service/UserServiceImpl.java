package com.javacoder.springbootrecaptcha.service;

import com.javacoder.springbootrecaptcha.entity.User;
import com.javacoder.springbootrecaptcha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public Integer createUser(User user) {
        Integer userId = repo.save(user).getId();
        return userId;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = repo.findAll();
        return users;
    }
}
