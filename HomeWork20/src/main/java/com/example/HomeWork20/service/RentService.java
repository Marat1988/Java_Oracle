package com.example.HomeWork20.service;

import com.example.HomeWork20.models.Rent;
import com.example.HomeWork20.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentService {
    private final RentRepository rentRepository;

    public List<Rent> rentlist(){
        return rentRepository.findAll();
    }

    public void save(Rent Rent) {
        rentRepository.save(Rent);
    }

    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }
}
