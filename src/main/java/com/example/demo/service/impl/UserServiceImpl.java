package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.api.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service1")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        // userRepository.findAll().forEach(value -> result.add(value));

        // for(User u: userRepository.findAll()){
        //     result.add(u);
        // }
        return result;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User save(String name, String email) {
        
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        return userRepository.save(n);
    }
    
}
