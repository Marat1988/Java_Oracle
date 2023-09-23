package com.example.HomeWork20.repository;

import com.example.HomeWork20.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RentRepository extends JpaRepository<Rent, Integer> {
}
