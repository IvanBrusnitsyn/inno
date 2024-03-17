package edu.innotech.inno.repository;

import edu.innotech.inno.model.ProductRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseProductRegisterRepo extends JpaRepository<ProductRegister, Long> {
}
