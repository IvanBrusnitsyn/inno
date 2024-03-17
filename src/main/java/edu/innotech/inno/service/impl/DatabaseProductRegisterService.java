package edu.innotech.inno.service.impl;

import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.DatabaseProductRegisterRepo;
import edu.innotech.inno.repository.ProductRegisterRepo;
import edu.innotech.inno.service.ProductRegisterService;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseProductRegisterService implements ProductRegisterService {
    private final DatabaseProductRegisterRepo productRegisterRepo;

    private final ProductService databaseProductService;
    @Override
    public List<ProductRegister> findAll() {
        return productRegisterRepo.findAll();
    }

    @Override
    public ProductRegister findById(Long id) {
        return productRegisterRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Продуктовый регистр по ID {0} не найден!", id)));
    }

    @Override
    public ProductRegister save(ProductRegister productRegister) {
        Product product = databaseProductService.findById(productRegister.getProductId().getId());
        productRegister.setProductId(product);
        return productRegisterRepo.save(productRegister);
    }

    @Override
    public ProductRegister update(ProductRegister productRegister) {
        Product product = databaseProductService.findById(productRegister.getProductId().getId());
        ProductRegister existedProductRegister = findById(productRegister.getId());

        BeanUtils.copyNonNullProperties(productRegister, existedProductRegister);
        existedProductRegister.setProductId(product);
        return productRegisterRepo.save(existedProductRegister);
    }

    @Override
    public void deleteById(Long id) {
//        ProductRegister currentProductRegister = findById(id);
//        currentProductRegister.getProductId().removeProductRegister(id);
        productRegisterRepo.deleteById(id);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        productRegisterRepo.deleteAllById(ids);
    }
}
