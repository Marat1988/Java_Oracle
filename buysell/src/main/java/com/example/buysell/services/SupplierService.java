package com.example.buysell.services;

import com.example.buysell.models.Supplier;
import com.example.buysell.models.User;
import com.example.buysell.models.enums.Role;
import com.example.buysell.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> listSupplier() {
        return supplierRepository.findAll();
    }

    public void updateInfoSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }

    public boolean createSupplier(Supplier supplier) {
        String name = supplier.getName();
        if (supplierRepository.findByName(name) != null) return false;
        log.info("Saving new Supplier with name: {}", supplier.getName());
        supplierRepository.save(supplier);
        return true;
    }

    public Supplier findSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }
}
