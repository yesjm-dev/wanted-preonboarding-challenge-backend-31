package com.yesjm.ecommerce.repository;

import com.yesjm.ecommerce.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
