package com.eybilal.esedminventoryservice.core.repository;

import com.eybilal.esedminventoryservice.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Collection<Product> findByName(String name);
}
