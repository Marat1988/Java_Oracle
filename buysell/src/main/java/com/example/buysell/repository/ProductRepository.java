package com.example.buysell.repository;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE ?1 IN (0, supplier_id) AND PRICE BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Product> findByProductQuery(Long SupplierId, Long priceBegin, Long priceEnd);

}
