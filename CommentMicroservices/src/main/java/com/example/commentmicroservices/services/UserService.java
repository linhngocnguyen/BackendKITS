package com.example.commentmicroservices.services;

import com.example.commentmicroservices.exception.UserDataNotPairingException;
import com.example.commentmicroservices.models.User;
import com.example.commentmicroservices.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public User updateUser(int id, User updatedUser) {
        User user = getUserById(id);
        // Update user fields
        user.setUsername(updatedUser.getUsername());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        return userRepository.save(user);
    }

    public void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPhoneNumber().equals(phoneNumber)) {
            userRepository.delete(user);
        } else {
            throw new UserDataNotPairingException("Username and phone number do not match.");
        }
    }
}
