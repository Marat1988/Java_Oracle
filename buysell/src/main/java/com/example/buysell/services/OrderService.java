package com.example.buysell.services;

import com.example.buysell.models.Orders;
import com.example.buysell.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void saveOrder(Long UserId, String Comment){
        orderRepository.up_ins_createOrder(UserId, Comment);
    }

    public List<Orders> findOrderByUserId(Long id) {
        return orderRepository.findOrderByUserId(id);
    }

    public Orders findOrderById(Long orderId){
        return orderRepository.findById(orderId).orElse(null);
    }
}
