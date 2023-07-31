package com.example.practicesecuritye6.controller;

import com.example.practicesecuritye6.service.MyGmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class SendMailController {
    @Autowired
    MyGmailService myGmailService;
    @GetMapping("/send")
    public String sendEmail(){
        try {
            myGmailService.sendEmail("nnl11052001@gmail.com", "Spring Boot ...", "Hello, is this me you looking for");
        } catch (Exception e){
            return "error";
        }
        return "null";
    }
}
