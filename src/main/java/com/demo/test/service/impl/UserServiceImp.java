package com.demo.test.service.impl;

import com.demo.test.entity.User;
import com.demo.test.repository.UserRepository;
import com.demo.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail().orElseThrow(() -> new RuntimeException(String.format("userNot found with email %s", email)));
    }
}
