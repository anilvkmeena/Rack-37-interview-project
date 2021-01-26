package com.demo.test.service;

import com.demo.test.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     User findByEmail(String email);
}
