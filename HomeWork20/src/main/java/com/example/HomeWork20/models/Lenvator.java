package com.example.HomeWork20.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*Арентодатель*/
@Entity
@Table(name = "lenvator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lenvator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name="telephone", length = 20)
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lenvator")
    private List<Apartment> apartmentList = new ArrayList<>();
}
