package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recycler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recycler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name="productId")
    private Long productId;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "productName")
    private String productName;

    public Recycler(Long userId, Long productId, int price, int quantity, String productName) {
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
    }
}
