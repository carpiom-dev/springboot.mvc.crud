package com.adrian.springboot.springmvc.app.service;

import com.adrian.springboot.springmvc.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void remove(Long id);

}
