package com.example.buysell.controllers;

import com.example.buysell.models.Supplier;
import com.example.buysell.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminSupplierController {
    private final SupplierService supplierService;

    @GetMapping("/admin/suppliers")
    public String admin(Model model) {
        model.addAttribute("suppliers", supplierService.listSupplier());
        return "suppliers";
    }

    @GetMapping("/admin/suppliers/edit/{id}")
    public String supplierEditForm(@PathVariable("id") Long id, Model model) {
        Supplier supplier = supplierService.listSupplier()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("supplier", supplier);
        Integer action = 1;
        model.addAttribute("action",action);
        return "supplierEditInsert";
    }

    @GetMapping("/admin/suppliers/insert")
    public String supplierInsertForm(Model model) {
        Integer action = 2;
        model.addAttribute("action",action);
        return "supplierEditInsert";
    }


    @PostMapping("/admin/suppliers/update")
    public String supplierUpdate(@RequestParam("supplierId") Supplier supplier, Supplier supplierUpdateInfo) {
        supplier.setName(supplierUpdateInfo.getName());
        supplierService.updateInfoSupplier(supplier);
        return "redirect:/admin/suppliers";
    }

    @PostMapping("/admin/suppliers/delete/{id}")
    public String supplierDelete(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return "redirect:/admin/suppliers";
    }

    @PostMapping("/admin/suppliers/create")
    public String createSupplier(Supplier supplier, Model model) {
        if (!supplierService.createSupplier(supplier)) {
            model.addAttribute("errorMessage", "Поставщик с наименованием " + supplier.getName() + " уже существует");
            return "redirect:/admin/suppliers/insert";
        }
        return "redirect:/admin/suppliers";
    }
}
