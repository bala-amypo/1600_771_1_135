package com.example.demo.config.service;

import com.example.demo.config.entity.User;
import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
}
