package com.test.testStefanini.repository;

import com.test.testStefanini.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
