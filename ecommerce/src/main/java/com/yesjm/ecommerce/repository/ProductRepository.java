package com.yesjm.ecommerce.repository;

import com.yesjm.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySlug(String slug);
}
