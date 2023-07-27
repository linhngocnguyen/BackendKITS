package com.example.flexbook.service;

import com.example.flexbook.model.Message;
import com.example.flexbook.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesFromUser(int user_id){
        return messageRepository.messageFromUser(user_id);
    }

    public List<Message> getMessagesToUser(int user_id){
        return messageRepository.messageToUser(user_id);
    }
}
