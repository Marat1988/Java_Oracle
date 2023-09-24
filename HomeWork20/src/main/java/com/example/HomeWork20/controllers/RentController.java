package com.example.HomeWork20.controllers;

import com.example.HomeWork20.models.Apartment;
import com.example.HomeWork20.models.Lenvator;
import com.example.HomeWork20.models.Rent;
import com.example.HomeWork20.models.Renter;
import com.example.HomeWork20.service.ApartmentService;
import com.example.HomeWork20.service.RentService;
import com.example.HomeWork20.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;
    private final RenterService renterService;
    private final ApartmentService apartmentService;

    @GetMapping("/rents")
    public String rents(Model model) {
        model.addAttribute("rents", rentService.rentlist());
        return "rents";
    }

    @GetMapping("/rent/edit/{id}")
    public String rentsEditForm(@PathVariable("id") int id, Model model) {
        Rent rent = rentService.rentlist()
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("rent", rent);
        Integer action = 1;
        model.addAttribute("action", action);
        model.addAttribute("apartments", apartmentService.apartmentList());
        model.addAttribute("renters", renterService.rentorlist());
        return "rentEditInsert";
    }

    @GetMapping("/rent/insert")
    public String rentInsertForm(Model model) {
        Integer action = 2;
        model.addAttribute("action", action);
        model.addAttribute("apartments", apartmentService.apartmentList());
        model.addAttribute("renters", renterService.rentorlist());
        return "rentEditInsert";
    }

    @PostMapping("/rent/update")
    public String rentUpdate(@RequestParam("apartmentId") Integer apartmentId,
                             @RequestParam("renterId") Integer renterId,
                             Rent rentUpdateInfo) {
        Apartment apartment = apartmentService.findById(apartmentId);
        Renter renter = renterService.findById(renterId);
        if (apartment != null && renter != null) {
            rentUpdateInfo.setApartment(apartment);
            rentUpdateInfo.setRenter(renter);
            rentService.save(rentUpdateInfo);
        }
        return "redirect:/rents";
    }

    @PostMapping("/rent/delete/{id}")
    public String rentDelete(@PathVariable Integer id) {
        rentService.delete(id);
        return "redirect:/rents";
    }

    @PostMapping("/rent/create")
    public String createApartment(@RequestParam("apartmentId") Integer apartmentId,
                                  @RequestParam("renterId") Integer renterId,
                                  Rent rent) {
        Renter renter = renterService.findById(renterId);
        Apartment apartment = apartmentService.findById(apartmentId);
        if (renter != null && apartment != null) {
            rent.setApartment(apartment);
            rent.setRenter(renter);
            rentService.save(rent);
        }
        return "redirect:/rents";
    }


}
