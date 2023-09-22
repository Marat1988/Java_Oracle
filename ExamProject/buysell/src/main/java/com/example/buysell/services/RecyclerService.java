package com.example.buysell.services;

import com.example.buysell.models.Product;
import com.example.buysell.models.Recycler;
import com.example.buysell.models.User;
import com.example.buysell.repository.RecyclerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecyclerService {
    private final RecyclerRepository recyclerRepository;

    public Recycler findById(Long id) {
        return recyclerRepository.findById(id).orElse(null);
    }

    public void deleteProductFromRecycler(Long id) {
        recyclerRepository.deleteById(id);
    }

    public void deleteRecyclerByProductId(Long productId){
        List<Recycler> recyclerList = recyclerRepository.findAll()
                        .stream()
                        .filter(item->item.getProductId().equals(productId))
                                .toList();
        recyclerRepository.deleteAll(recyclerList);
    }

    public void addProductToRecycler(Product product, User user) {
        Recycler recycler = new Recycler(user.getId(), product.getId(), product.getPrice(), 1, product.getTitle());
        recyclerRepository.save(recycler);
    }

    public void recyclerSave(Recycler recycler) {
        recyclerRepository.save(recycler);
    }

    public List<Recycler> recyclerList(Long userId) {
        return recyclerRepository.findAll()
                .stream()
                .filter(item -> item.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public Long recyclerCountUserProduct(Long userId, Long productId) {
        return recyclerRepository.findAll()
                .stream()
                .filter(item -> item.getUserId().equals(userId) && item.getProductId().equals(productId))
                .count();
    }

    public Recycler findProductByUser(Long userId, Long productId) {
        return recyclerRepository.findAll()
                .stream()
                .filter(item -> item.getUserId().equals(userId) && item.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }


}
