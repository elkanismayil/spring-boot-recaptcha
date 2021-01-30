package com.javacoder.springbootrecaptcha.repository;

import com.javacoder.springbootrecaptcha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
