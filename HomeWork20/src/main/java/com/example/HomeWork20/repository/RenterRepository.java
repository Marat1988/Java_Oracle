package com.example.HomeWork20.repository;

import com.example.HomeWork20.models.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RenterRepository extends JpaRepository<Renter, Integer> {
}
