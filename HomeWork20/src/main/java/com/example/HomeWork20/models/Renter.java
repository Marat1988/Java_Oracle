package com.example.HomeWork20.models;


/*Арендатор*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*Арендатор*/
@Entity
@Table(name = "renter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name="telephone", length = 20)
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "renter")
    private List<Rent> rentList = new ArrayList<>();
}
