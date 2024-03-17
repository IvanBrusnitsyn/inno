package edu.innotech.inno.repository.impl;

import edu.innotech.inno.model.Agreement;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.AgreementRepo;
import edu.innotech.inno.repository.ProductRepo;
import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//@Repository
@Component
public class InMemoryAgreementRepo implements AgreementRepo {
    private ProductRepo productRepo;
    private final Map<Long,Agreement> repository = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(1);

    @Override
    public List<Agreement> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Agreement> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Agreement save(Agreement agreement) {
        Long agreementId = currentId.getAndIncrement();
        Long productId = agreement.getProductId().getId();
        Product product = productRepo.findById(productId).
                orElseThrow(() -> new EntityNotFoundException("Продукт не найден!"));
        agreement.setProductId(product);
        agreement.setId(agreementId);
        Instant now = Instant.now();
        agreement.setOpeningDate(now);

        repository.put(agreementId, agreement);

//        product.addAgreement(agreement);

        productRepo.update(product);

        return agreement;
    }

    @Override
    public Agreement update(Agreement agreement) {
        Long agreementId = agreement.getId();
        Agreement currentAgreement = repository.get(agreementId);

        if (currentAgreement == null) {
            throw new EntityNotFoundException(MessageFormat.format("Соглашение по ID {0} не найден!", agreementId));
        }
        BeanUtils.copyNonNullProperties(agreement, currentAgreement);
        currentAgreement.setId(agreementId);
        repository.put(agreementId, currentAgreement);
        return currentAgreement;
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
