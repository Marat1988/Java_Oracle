package com.example.buysell.repository;

import com.example.buysell.models.Supplier;
import com.example.buysell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findByName (String name);
}
