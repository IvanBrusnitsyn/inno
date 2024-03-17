package edu.innotech.inno.repository;

import edu.innotech.inno.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseProductRepo extends JpaRepository<Product, Long> {
}
