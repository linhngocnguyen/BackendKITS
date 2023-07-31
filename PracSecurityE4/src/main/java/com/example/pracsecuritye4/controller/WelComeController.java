package com.example.pracsecuritye4.controller;

import com.example.pracsecuritye4.model.Users;
import com.example.pracsecuritye4.service.CustomUserDetailsService;
import com.example.pracsecuritye4.service.MyGmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class WelComeController {
    @Autowired
    CustomUserDetailsService myUserService;

    @Autowired
    MyGmailService mySender;
    @GetMapping("/welcome")
    public String greeting() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
        public String register(Model model){
            Users myUser = new Users();
            model.addAttribute("user", myUser);
            return "register";
        }
    @PostMapping("/register")
        public String saveRegister(@ModelAttribute Users user){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


//        System.out.println(generatedString);
        user.setActivationCode(generatedString);
        myUserService.addNewRegister(user);

//            MyGmailService mySender = new MyGmailService();
            mySender.sendEmail(user.getEmail(), "Account activation", "Please click here: http://localhost:8080/activation/"+user.getEmail()+"/"+generatedString);
            return "redirect:/welcome";
    }
    @GetMapping("/activation/{email}/{activationCode}")
    public String activateAccount(@PathVariable String email, @PathVariable String activationCode) {
        Users user = myUserService.getUserByEmail(email);
        if (user == null || !user.getActivationCode().equals(activationCode)) {
            // Handle invalid activation link
            return "redirect:/activation-error";
        } else {
            user.setStatus(true);
            myUserService.addNewRegister(user);
            // Handle successful activation
            return "redirect:/activation-success";
        }
    }
}
