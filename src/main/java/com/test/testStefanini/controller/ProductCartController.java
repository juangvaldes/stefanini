package com.test.testStefanini.controller;

import com.test.testStefanini.dao.ProductCartDAO;
import com.test.testStefanini.model.ProductCart;
import com.test.testStefanini.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_cart")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ProductCartController {

    @Autowired
    private ProductCartDAO productCartDAO;

    @PostMapping(value = "/add_product", produces = MediaType.APPLICATION_JSON_VALUE)
    public void loginUser(@RequestBody String body) {
        productCartDAO.save(body);
    }

    @GetMapping(value = "/get_products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> getProductsCart(@RequestParam int idUser) {
        return productCartDAO.getProductsCart(idUser);
    }

    @GetMapping(value = "delete_product_cart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProductCart(@RequestParam int idProduct) {
        return productCartDAO.delete(idProduct);
    }

}
