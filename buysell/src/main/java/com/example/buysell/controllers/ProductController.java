package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.models.Recycler;
import com.example.buysell.models.User;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.RecyclerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final RecyclerService recyclerService;

    @GetMapping("/")
    public String products(Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }


    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }


    @PostMapping("/product/buy/{id}")
    public String buyProduct(@PathVariable Long id, Principal principal) {
        Product product = productService.getProductById(id);
        User user = productService.getUserByPrincipal(principal);
        if (product != null) {
            if (recyclerService.recyclerCountUserProduct(user.getId(), product.getId()) > 0)
            {
                Recycler recycler = recyclerService.findProductByUser(user.getId(), product.getId());
                recycler.setQuantity(recycler.getQuantity()+1);
                recyclerService.recyclerSave(recycler);
            }
            else{
                recyclerService.addProductToRecycler(product, user);
            }
        }
        return "redirect:/";
    }
}
