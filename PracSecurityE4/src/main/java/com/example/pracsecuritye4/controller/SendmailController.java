package com.example.pracsecuritye4.controller;

import com.example.pracsecuritye4.service.MyGmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class SendmailController {
    @Autowired
    MyGmailService mySender;
    @GetMapping("/send")
    public String sendEmail(){
        try{
            mySender.sendEmail("nnl11052001@gmail.com","Spring Boot ....", "Hello from Spring Boot to Gmail");
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
        return "mail";
    }
}
