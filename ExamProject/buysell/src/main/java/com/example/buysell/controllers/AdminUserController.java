package com.example.buysell.controllers;

import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminUserController {
    private final UserService userService;

    /*Действия с пользователями*/
    @GetMapping("/admin/users")
    public String admin(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @PostMapping("/admin/users/ban/{id}")
    public String userBan(@PathVariable("id") Long id) {
        userService.banUser(id);
        return "redirect:/admin/users";
    }
    @GetMapping("/admin/users/edit/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
        User user = userService.listUsers()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/admin/users/update")
    public String userUpdate(@RequestParam("userId") User user, User userUpdateInfo) {
        user.setFullname(userUpdateInfo.getFullname());
        user.setCity(userUpdateInfo.getCity());
        user.setPhoneNumber(userUpdateInfo.getPhoneNumber());
        user.setEmail(userUpdateInfo.getEmail());
        userService.updateInfoUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/users/delete/{id}")
    public String userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
