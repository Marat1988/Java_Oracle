package com.example.buysell.repository;

import com.example.buysell.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Procedure
    void up_ins_createOrder(Long UserId, String Comment);
    List<Orders> findOrderByUserId(Long userId);
}
