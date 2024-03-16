package edu.innotech.inno.service.impl;

import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.exception.UpdateStateException;
import edu.innotech.inno.model.Agreement;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.repository.AgreementRepo;
import edu.innotech.inno.repository.ProductRepo;
import edu.innotech.inno.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepo agreementRepo;
    @Override
    public List<Agreement> findAll() {
        return agreementRepo.findAll();
    }

    @Override
    public Agreement findById(Long id) {
        return agreementRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Соглашение по ID {0} не найдено!", id)));
    }

    @Override
    public Agreement save(Agreement agreement) {
        return agreementRepo.save(agreement);
    }

    @Override
    public Agreement update(Agreement agreement) {
        return agreementRepo.update(agreement);
    }

    @Override
    public void deleteById(Long id) {
        Agreement currentAgreement = findById(id);
//        currentAgreement.getProductId().removeAgreement(id);
        agreementRepo.deleteById(id);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        agreementRepo.deleteByIdIn(ids);
    }

//    private void checkForUpdate(Long agreementId){
//        Agreement currentAgreement = findById(agreementId);
//        Instant now = Instant.now();
//
//        Duration duration = Duration.between(currentAgreement.getOpeningDate(),now);
//        if (duration.getSeconds() > 5) {
//            throw new UpdateStateException("Невозможно обновить Соглашение!");
//        }
//    }
}
