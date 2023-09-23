package com.example.HomeWork20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StartPage {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
