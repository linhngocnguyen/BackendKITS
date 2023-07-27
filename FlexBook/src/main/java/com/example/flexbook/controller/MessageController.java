package com.example.flexbook.controller;

import com.example.flexbook.model.Comment;
import com.example.flexbook.model.Message;
import com.example.flexbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/to/{user_id}")
    public List<Message> getMessagesToUser(@PathVariable int user_id) {
        return messageService.getMessagesToUser(user_id);
    }
    @GetMapping("/from/{user_id}")
    public List<Message> getCommentsByUser(@PathVariable int user_id) {
        return messageService.getMessagesFromUser(user_id);
    }
}
