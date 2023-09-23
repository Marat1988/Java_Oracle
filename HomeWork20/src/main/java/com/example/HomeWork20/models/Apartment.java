package com.example.HomeWork20.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;

/*Квартиры*/
@Entity
@Table(name = "apartments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "room_count>0")
@Check(constraints = "price>0")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "room_count")
    private int roomCount;
    @Column(name = "price")
    private int price;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Lenvator lenvator;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartment")
    private List<Rent> rentsApartment = new ArrayList<>();
}
