package com.example.HomeWork20.service;

import com.example.HomeWork20.models.Apartment;
import com.example.HomeWork20.models.Renter;
import com.example.HomeWork20.repository.ApartmentRepository;
import com.example.HomeWork20.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public List<Apartment> apartmentList(){
        return apartmentRepository.findAll();
    }

    public void save(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    public void delete(Integer id) {
        apartmentRepository.deleteById(id);
    }

    public Apartment findById(Integer apartmentId) {
        return apartmentRepository.findById(apartmentId).orElse(null);
    }
}
