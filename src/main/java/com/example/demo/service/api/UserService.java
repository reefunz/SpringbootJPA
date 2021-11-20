package com.example.demo.service.api;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
    List<User> getAll();
    User getById(Integer id);
    User save(String name, String email);
}
