package com.example.flexbook.service;

import com.example.flexbook.model.User;
import com.example.flexbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User newUser) throws Exception {
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new Exception("User with email " + newUser.getEmail() + " already exists");
        }
        newUser.setCreated_at(Timestamp.from(Instant.now()));
        return userRepository.save(newUser);
    }
}