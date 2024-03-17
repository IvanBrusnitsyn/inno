package edu.innotech.inno.repository.impl;

import edu.innotech.inno.model.Agreement;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.AgreementRepo;
import edu.innotech.inno.repository.ProductRegisterRepo;
import edu.innotech.inno.repository.ProductRepo;
//import jakarta.persistence.EntityNotFoundException;
import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.utils.BeanUtils;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

//@Repository
@Component
public class InMemoryProductRepo implements ProductRepo {
    private ProductRegisterRepo productRegisterRepo;
//    private AgreementRepo agreementRepo;
    private final Map<Long,Product> repository = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(1);

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Product save(Product product) {
        Long productId = currentId.getAndIncrement();
        product.setId(productId);
        repository.put(productId, product);
        return product;
    }

    @Override
    public Product update(Product product) {
        Long productId = product.getId();
        Product currentProduct = repository.get(productId);
        if (currentProduct == null) {
            throw new EntityNotFoundException(MessageFormat.format("Продукт по ID {0} не найден!", productId));
        }
        BeanUtils.copyNonNullProperties(product, currentProduct);
        currentProduct.setId(productId);
        repository.put(productId, currentProduct);
        return currentProduct;
    }

    @Override
    public void deleteById(Long id) {
        Product product = repository.get(id);
        if (product == null) {
            throw new EntityNotFoundException(MessageFormat.format("Продукт по ID {0} не найден!", id));
        }
//        agreementRepo.deleteByIdIn(product.
//                getAgreements().
//                stream().
//                map(Agreement::getId).
//                collect(Collectors.toList())
//        );
        productRegisterRepo.deleteByIdIn(product.
                getProductRegisters().
                stream().
                map(ProductRegister::getId).
                collect(Collectors.toList())
        );
        repository.remove(id);
    }

    @Autowired
    public void setProductRegisterRepo(ProductRegisterRepo productRegisterRepo) {
        this.productRegisterRepo = productRegisterRepo;
    }
//    @Autowired
//    public void setAgreementRepo(AgreementRepo agreementRepo) {
//        this.agreementRepo = agreementRepo;
//    }
}
