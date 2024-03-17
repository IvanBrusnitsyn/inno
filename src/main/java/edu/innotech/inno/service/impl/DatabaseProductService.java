package edu.innotech.inno.service.impl;

import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.repository.DatabaseProductRepo;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseProductService implements ProductService {
    @Autowired
    private final DatabaseProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format(
                        "Продукт с ID {0} не найден!", id)));
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        Product existedClient = findById(product.getId());

        BeanUtils.copyNonNullProperties(product, existedClient);

        return productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }
}
