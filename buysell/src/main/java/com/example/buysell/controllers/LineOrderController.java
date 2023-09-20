package com.example.buysell.controllers;

import com.example.buysell.models.Lineorder;
import com.example.buysell.models.Orders;
import com.example.buysell.models.User;
import com.example.buysell.services.LineOrderService;
import com.example.buysell.services.OrderService;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class LineOrderController {
    private final LineOrderService lineOrderService;
    private final OrderService orderService;
    private final ProductService productService;

    @RequestMapping(value = "/lineOrder/{orderId}", method = RequestMethod.GET)
    public String productByOrder(@PathVariable Long orderId, Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        Orders order = orderService.findOrderById(orderId);
        if (order != null && Objects.equals(order.getUser().getId(), user.getId())) {
            List<Lineorder> lineOrders = lineOrderService.productFromOrder(orderId);
            model.addAttribute("lineOrders", lineOrders);
            model.addAttribute("numberOrder", orderId);
            return "order-info";
        } else {
            return "redirect:/";
        }
    }

}
