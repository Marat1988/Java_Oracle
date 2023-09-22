package com.example.buysell.controllers;

import com.example.buysell.models.*;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.RecyclerService;
import com.example.buysell.services.SupplierService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final RecyclerService recyclerService;
    private final SupplierService supplierService;

    @GetMapping("/")
    public String products(Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("suppliers", supplierService.listSupplier());
        return "products";
    }

//    https://www.baeldung.com/spring-requestmapping
    @RequestMapping(value = "/product/find", method = GET)
    public String productSearch(
            @RequestParam("supplierId") long supplierId,
            @RequestParam("priceBegin") long priceBegin,
            @RequestParam("priceEnd") long priceEnd,
            Principal principal, Model model) {
        List<Product> products = productService.findProductQuery(supplierId, priceBegin, priceEnd);
        model.addAttribute("products",products);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("suppliers", supplierService.listSupplier());
        return "products";
    }


    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }


    /*Old method*/
    /*@PostMapping("/product/buy/{id}")
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
    }*/

}
