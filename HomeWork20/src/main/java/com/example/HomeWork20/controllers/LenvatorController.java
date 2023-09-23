package com.example.HomeWork20.controllers;

import com.example.HomeWork20.models.Lenvator;
import com.example.HomeWork20.service.LenvatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LenvatorController {
    private final LenvatorService lenvatorService;

    @GetMapping("/lenvators")
    public String lenvators(Model model){
        model.addAttribute("lenvators", lenvatorService.lenvatorList());
        return "lenvators";
    }

    @GetMapping("/lenvator/edit/{id}")
    public String lenvatorEditForm(@PathVariable("id") int id, Model model) {
        Lenvator lenvator = lenvatorService.lenvatorList()
                .stream()
                .filter(item -> item.getId()==id)
                .findFirst()
                .orElse(null);
        model.addAttribute("lenvator", lenvator);
        Integer action = 1;
        model.addAttribute("action", action);
        return "lenvatorEditInsert";
    }

    @GetMapping("/lenvator/insert")
    public String lenvatorInsertForm(Model model) {
        Integer action = 2;
        model.addAttribute("action", action);
        return "lenvatorEditInsert";
    }

    @PostMapping("/lenvator/update")
    public String lenvatorUpdate(Lenvator lenvatorUpdateInfo) {
        lenvatorService.save(lenvatorUpdateInfo);
        return "redirect:/lenvators";
    }

    @PostMapping("/lenvator/delete/{id}")
    public String lenvatorDelete(@PathVariable Integer id) {
        lenvatorService.delete(id);
        return "redirect:/lenvators";
    }

    @PostMapping("/lenvator/create")
    public String createLenvator(Lenvator lenvator) {
        lenvatorService.save(lenvator);
        return "redirect:/lenvators";
    }
}
