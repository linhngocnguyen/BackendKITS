package com.example.flexbook.controller;

import com.example.flexbook.model.User;
import com.example.flexbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok().body(newUser);
    }
}
