package com.example.buysell.services;

import com.example.buysell.models.Lineorder;
import com.example.buysell.repository.LineOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LineOrderService {
    private final LineOrderRepository lineOrderRepository;

    public List<Lineorder> productFromOrder(Long orderId){
        return lineOrderRepository.findAll().stream().filter(item-> Objects.equals(item.getOrder().getId(), orderId)).collect(Collectors.toList());
    }
}
