package com.adrian.springboot.springmvc.app.repositories;

import com.adrian.springboot.springmvc.app.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
