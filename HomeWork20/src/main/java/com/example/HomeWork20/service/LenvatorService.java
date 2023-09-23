package com.example.HomeWork20.service;

import com.example.HomeWork20.models.Lenvator;
import com.example.HomeWork20.repository.LenvatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LenvatorService {
    private final LenvatorRepository lenvatorRepository;

    public List<Lenvator> lenvatorList(){
        return lenvatorRepository.findAll();
    }

    public void save(Lenvator lenvator) {
        lenvatorRepository.save(lenvator);
    }

    public void delete(Integer id) {
        lenvatorRepository.deleteById(id);
    }

    public Lenvator findById(Integer lenvatorId) {
        return lenvatorRepository.findById(lenvatorId).orElse(null);
    }
}
