package com.example.buysell.controllers;

import com.example.buysell.models.Recycler;
import com.example.buysell.models.User;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.RecyclerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RecyclerController {
    private final RecyclerService recyclerService;
    private final ProductService productService;

    @GetMapping("/product/recycler")
    public String recycler(Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        model.addAttribute("recyclerAll", recyclerService.recyclerList(user.getId()));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "recycler";
    }

    @PostMapping("/product/recycler/delete/{recyclerId}")
    public String productRemoveFromRecycle(@PathVariable Long recyclerId) {
        recyclerService.deleteProductFromRecycler(recyclerId);
        return "redirect:/product/recycler";

    }

    @PostMapping("/product/recycle/update")
    public String productUpdateQuantityFromRecycler(Recycler recyclerUpdate) {
        Recycler recycler = recyclerService.findById(recyclerUpdate.getId());
        if (recycler != null) {
            recycler.setQuantity(recyclerUpdate.getQuantity());
            recyclerService.recyclerSave(recycler);
        }
        return "redirect:/product/recycler";
    }
}
