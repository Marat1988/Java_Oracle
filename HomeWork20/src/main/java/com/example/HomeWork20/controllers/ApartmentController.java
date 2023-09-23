package com.example.HomeWork20.controllers;

import com.example.HomeWork20.models.Apartment;
import com.example.HomeWork20.models.Lenvator;
import com.example.HomeWork20.service.ApartmentService;
import com.example.HomeWork20.service.LenvatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final LenvatorService lenvatorService;

    @GetMapping("/apartments")
    public String apartments(Model model) {
        model.addAttribute("apartments", apartmentService.apartmentList());
        return "apartments";
    }

    @GetMapping("/apartment/edit/{id}")
    public String apartment(@PathVariable("id") int id, Model model) {
        Apartment apartment = apartmentService.apartmentList()
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("apartment", apartment);
        model.addAttribute("lenvators", lenvatorService.lenvatorList());
        Integer action = 1;
        model.addAttribute("action", action);
        return "apartmentEditInsert";
    }

    @GetMapping("/apartment/insert")
    public String apartmentInsertForm(Model model) {
        Integer action = 2;
        model.addAttribute("action", action);
        model.addAttribute("lenvators", lenvatorService.lenvatorList());
        return "apartmentEditInsert";
    }

    @PostMapping("/apartment/update")
    public String lenvatorUpdate(@RequestParam("lenvatorId") Integer lenvatorId, Apartment apartmentUpdateInfo) {
        Lenvator lenvator = lenvatorService.findById(lenvatorId);
        if (lenvator != null) {
            apartmentUpdateInfo.setLenvator(lenvator);
            apartmentService.save(apartmentUpdateInfo);
        }
        return "redirect:/apartments";
    }

    @PostMapping("/apartment/delete/{id}")
    public String apartmentDelete(@PathVariable Integer id) {
        apartmentService.delete(id);
        return "redirect:/apartments";
    }

    @PostMapping("/apartment/create")
    public String createApartment(@RequestParam("lenvatorId") Integer lenvatorId, Apartment apartment) {
        Lenvator lenvator = lenvatorService.findById(lenvatorId);
        if (lenvator != null) {
            apartment.setLenvator(lenvator);
            apartmentService.save(apartment);
        }
        return "redirect:/apartments";
    }
}
