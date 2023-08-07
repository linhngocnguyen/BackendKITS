package com.example.ecommerce.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/documentation")
    public String redirectToSwaggerUI() {
        return "redirect:/swagger-ui/index.html";
    }
}