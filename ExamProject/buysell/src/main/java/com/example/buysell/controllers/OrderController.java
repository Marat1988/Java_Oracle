package com.example.buysell.controllers;

import com.example.buysell.models.Orders;
import com.example.buysell.models.User;
import com.example.buysell.services.OrderService;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @PostMapping("/order/create")
    public String createOrder(Orders order, Principal principal){
        User user = productService.getUserByPrincipal(principal);
        orderService.saveOrder(user.getId(),order.getComment());
        return "redirect:/product/recycler";
    }

    @GetMapping("/product/orders")
    public String userOrders(Principal principal, Model model){
        User user = productService.getUserByPrincipal(principal);
        List<Orders> ordersList = orderService.findOrderByUserId(user.getId());
        model.addAttribute("orders", ordersList);
        return "order-list";
    }
}
