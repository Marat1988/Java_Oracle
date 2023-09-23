package com.example.HomeWork20.controllers;

import com.example.HomeWork20.models.Renter;
import com.example.HomeWork20.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RenterController {
    private final RenterService renterService;

    @GetMapping("/renters")
    public String renters(Model model) {
        model.addAttribute("renters", renterService.rentorlist());
        return "renters";
    }

    @GetMapping("/renter/edit/{id}")
    public String renterEditForm(@PathVariable("id") int id, Model model) {
        Renter renter = renterService.rentorlist()
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("renter", renter);
        Integer action = 1;
        model.addAttribute("action", action);
        return "renterEditInsert";
    }

    @GetMapping("/renter/insert")
    public String renterInsertForm(Model model) {
        Integer action = 2;
        model.addAttribute("action", action);
        return "renterEditInsert";
    }

    @PostMapping("/renter/update")
    public String renterUpdate(Renter renterUpdateInfo) {
        renterService.save(renterUpdateInfo);
        return "redirect:/renters";
    }

    @PostMapping("/renter/delete/{id}")
    public String renterDelete(@PathVariable Integer id) {
        renterService.delete(id);
        return "redirect:/renters";
    }

    @PostMapping("/renter/create")
    public String createRenter(Renter renter) {
        renterService.save(renter);
        return "redirect:/renters";
    }
}
