package com.neosoft.springbootCurdOperation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        return "welcome to our project";
    }

    @GetMapping("/message")
    public String getMessage(){
        return "message";
    }
}
