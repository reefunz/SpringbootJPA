package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.service.api.UserService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service2")
public class UserServiceImpl2 implements UserService {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User save(String name, String email) {
        return null;
    }
    
}
