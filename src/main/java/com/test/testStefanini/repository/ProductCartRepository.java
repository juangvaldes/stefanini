package com.test.testStefanini.repository;

import com.test.testStefanini.model.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
}
