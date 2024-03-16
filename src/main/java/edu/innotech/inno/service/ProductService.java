package edu.innotech.inno.service;

import edu.innotech.inno.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);



}
