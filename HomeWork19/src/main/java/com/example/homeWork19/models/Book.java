package com.example.homeWork19.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "pageCount > 0")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name", length = 100, nullable = false)
    private String name;
    @Column(name="author", length = 50, nullable = false)
    private String author;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "style", length = 20, nullable = false)
    private String style;
    @Column(name = "pageCount", nullable = false)
    private int pageCount;
    @Column(name = "description", nullable = false)
    private String description;
}
