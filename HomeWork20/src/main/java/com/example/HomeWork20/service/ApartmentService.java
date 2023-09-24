package com.example.HomeWork20.service;

import com.example.HomeWork20.models.Apartment;
import com.example.HomeWork20.models.Renter;
import com.example.HomeWork20.repository.ApartmentRepository;
import com.example.HomeWork20.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.ToLongFunction;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public List<Apartment> apartmentList() {
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

    public int maxPrice() {
        return Objects.requireNonNull(apartmentRepository.findAll().stream().max(Comparator.comparingInt(Apartment::getPrice)).orElse(null)).getPrice();
    }

    public int minPrice() {
        return Objects.requireNonNull(apartmentRepository.findAll().stream().min(Comparator.comparingInt(Apartment::getPrice)).orElse(null)).getPrice();
    }

    public double avgPrice() {
        return 1.0 * apartmentRepository.findAll().stream().mapToLong(Apartment::getPrice).sum() / apartmentRepository.findAll().size();
    }
}
