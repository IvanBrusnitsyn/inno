package edu.innotech.inno.service;

import edu.innotech.inno.model.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementService {
    List<Agreement> findAll();
    Agreement findById(Long id);
    Agreement save(Agreement agreement);
    Agreement update(Agreement agreement);
    void deleteById(Long id);
    void deleteByIdIn(List<Long> ids);
}
