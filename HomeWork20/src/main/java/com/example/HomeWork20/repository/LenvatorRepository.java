package com.example.HomeWork20.repository;

import com.example.HomeWork20.models.Lenvator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenvatorRepository extends JpaRepository<Lenvator, Integer> {
}
