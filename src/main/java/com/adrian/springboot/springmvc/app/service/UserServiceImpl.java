package com.adrian.springboot.springmvc.app.service;

import com.adrian.springboot.springmvc.app.entities.User;
import com.adrian.springboot.springmvc.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }
    }
}
