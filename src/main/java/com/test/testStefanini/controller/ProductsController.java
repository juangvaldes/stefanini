package com.test.testStefanini.controller;

import com.test.testStefanini.dao.ProductsDAO;
import com.test.testStefanini.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ProductsController {

    @Autowired
    private ProductsDAO productsDAO;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> getAllProducts(){
        return productsDAO.findAll();
    }
}
