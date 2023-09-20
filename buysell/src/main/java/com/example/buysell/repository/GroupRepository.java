package com.example.buysell.repository;

import com.example.buysell.models.Group;
import com.example.buysell.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName (String name);
}
