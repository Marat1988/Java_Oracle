package com.example.buysell.repository;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);


}
