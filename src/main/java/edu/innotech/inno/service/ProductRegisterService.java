package edu.innotech.inno.service;

import edu.innotech.inno.model.ProductRegister;

import java.util.List;
import java.util.Optional;

public interface ProductRegisterService {
    List<ProductRegister> findAll();
    ProductRegister findById(Long id);
    ProductRegister save(ProductRegister productRegister);
    ProductRegister update(ProductRegister productRegister);
    void deleteById(Long id);
    void deleteByIdIn(List<Long> ids);
}
