package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.models.Recycler;
import com.example.buysell.models.User;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.RecyclerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@RestController
@Slf4j
@AllArgsConstructor
public class RecyclerRestController {
    private final ProductService productService;
    private final RecyclerService recyclerService;

    @PostMapping("/product/buy")
    public ResponseEntity<String> buyProduct(@RequestParam("id") Long id, Principal principal) throws JSONException {
        Product product = productService.getProductById(id);
        User user = productService.getUserByPrincipal(principal);
        if (product != null) {
            if (recyclerService.recyclerCountUserProduct(user.getId(), product.getId()) > 0) {
                Recycler recycler = recyclerService.findProductByUser(user.getId(), product.getId());
                recycler.setQuantity(recycler.getQuantity() + 1);
                recyclerService.recyclerSave(recycler);
            } else {
                recyclerService.addProductToRecycler(product, user);
            }
        }
        JSONObject resp = new JSONObject();
        Long quantity = recyclerService.recyclerList(user.getId())
                .stream()
                .mapToLong(Recycler::getQuantity)
                .sum();
        resp.put("quantity", quantity);
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
    }
}
