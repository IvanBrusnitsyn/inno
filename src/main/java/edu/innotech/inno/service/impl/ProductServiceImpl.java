package edu.innotech.inno.service.impl;

import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.repository.ProductRepo;
import edu.innotech.inno.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Продукт по ID {0} не найден!", id)));
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.update(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }
}
