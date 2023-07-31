package com.example.practicesecuritye6.service;

import com.example.practicesecuritye6.dto.UserDto;
import com.example.practicesecuritye6.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
