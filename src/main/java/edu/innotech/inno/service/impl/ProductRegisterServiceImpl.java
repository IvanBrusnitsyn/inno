package edu.innotech.inno.service.impl;

import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.AgreementRepo;
import edu.innotech.inno.repository.ProductRegisterRepo;
import edu.innotech.inno.service.ProductRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductRegisterServiceImpl implements ProductRegisterService {
    private final ProductRegisterRepo productRegisterRepo;
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
        return productRegisterRepo.save(productRegister);
    }

    @Override
    public ProductRegister update(ProductRegister productRegister) {
        return productRegisterRepo.update(productRegister);
    }

    @Override
    public void deleteById(Long id) {
        ProductRegister currentProductRegister = findById(id);
        currentProductRegister.getProductId().removeProductRegister(id);
        productRegisterRepo.deleteById(id);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        productRegisterRepo.deleteByIdIn(ids);
    }
}
