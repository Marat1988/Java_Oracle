package com.example.buysell.controllers;


import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    private String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email " + user.getEmail() + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/user/update")
    public String groupUpdate(@RequestParam("userId") User user, User userUpdateInfo) {
        user.setFullname(userUpdateInfo.getFullname());
        user.setEmail(userUpdateInfo.getEmail());
        user.setPhoneNumber(userUpdateInfo.getPhoneNumber());
        user.setCity(userUpdateInfo.getCity());
        userService.updateInfoUser(user);
        return "redirect:/";
    }
}
