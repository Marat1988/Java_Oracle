package com.example.HomeWork20.service;

import com.example.HomeWork20.models.Lenvator;
import com.example.HomeWork20.models.Renter;
import com.example.HomeWork20.repository.LenvatorRepository;
import com.example.HomeWork20.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RenterService {
    private final RenterRepository renterRepository;

    public List<Renter> rentorlist(){
        List<Renter> renters = renterRepository.findAll();
        return renterRepository.findAll();
    }

    public void save(Renter renter) {
        renterRepository.save(renter);
    }

    public void delete(Integer id) {
        renterRepository.deleteById(id);
    }
}

