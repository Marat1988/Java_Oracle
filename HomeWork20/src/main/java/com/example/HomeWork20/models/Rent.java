package com.example.HomeWork20.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDateTime;

/*Таблицв аренд*/
@Entity
@Table(name = "rent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="date_Time_Rent")
    private LocalDateTime dateTimeRent; //Дата начала аренды
    @Column(name="is_End")
    private boolean isEnd; //Признак, что аренда закончилась
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Renter renter;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Apartment apartment;
}
