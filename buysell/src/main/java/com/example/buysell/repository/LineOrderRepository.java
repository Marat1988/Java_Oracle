package com.example.buysell.repository;

import com.example.buysell.models.Lineorder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineOrderRepository extends JpaRepository<Lineorder, Long> {

}
