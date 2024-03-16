package edu.innotech.inno.repository;

import edu.innotech.inno.model.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementRepo {
    List<Agreement> findAll();
    Optional<Agreement> findById(Long id);
    Agreement save(Agreement agreement);
    Agreement update(Agreement agreement);
    void deleteById(Long id);
    void deleteByIdIn(List<Long> ids);
}
