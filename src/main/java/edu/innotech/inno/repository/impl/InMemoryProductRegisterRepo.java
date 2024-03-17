package edu.innotech.inno.repository.impl;

import edu.innotech.inno.model.Agreement;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.ProductRegisterRepo;
import edu.innotech.inno.repository.ProductRepo;
import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//@Repository
@Component
public class InMemoryProductRegisterRepo implements ProductRegisterRepo {
    private ProductRepo productRepo;
    private final Map<Long, ProductRegister> repository = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(1);
    @Override
    public List<ProductRegister> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<ProductRegister> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public ProductRegister save(ProductRegister productRegister) {
        Long productRegisterId = currentId.getAndIncrement();
        Long productId = productRegister.getProductId().getId();
        Product product = productRepo.findById(productId).
                orElseThrow(() -> new EntityNotFoundException("Продукт не найден!"));

        productRegister.setProductId(product);
        productRegister.setId(productRegisterId);

        repository.put(productRegisterId, productRegister);

        product.addProductRegister(productRegister);

        productRepo.update(product);

        return productRegister;
    }

    @Override
    public ProductRegister update(ProductRegister productRegister) {
        Long productRegisterId = productRegister.getId();
        ProductRegister currentProductRegister = repository.get(productRegisterId);

        if (currentProductRegister == null) {
            throw new EntityNotFoundException(MessageFormat.format("Продуктовый регистр по ID {0} не найден!", productRegisterId));
        }
        BeanUtils.copyNonNullProperties(productRegister, currentProductRegister);
        currentProductRegister.setId(productRegisterId);
        repository.put(productRegisterId, currentProductRegister);
        return currentProductRegister;
    }

    @Override
    public void deleteById(Long id) {
        repository.remove(id);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(repository::remove);
    }
    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
