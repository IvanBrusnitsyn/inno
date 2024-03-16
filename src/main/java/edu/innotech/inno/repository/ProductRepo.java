package edu.innotech.inno.repository;

import edu.innotech.inno.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Product update(Product product);
    void deleteById(Long id);

}
