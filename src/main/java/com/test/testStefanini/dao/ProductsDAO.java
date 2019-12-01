package com.test.testStefanini.dao;

import com.test.testStefanini.model.Products;
import com.test.testStefanini.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsDAO {

    @Autowired
    private ProductsRepository productsRepository;

    public ProductsDAO(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public ResponseEntity findOne(Long id) {

        Products products = productsRepository.findById(id).get();

        if(products==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(products);
    }
}
