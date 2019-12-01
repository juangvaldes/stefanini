package com.test.testStefanini.dao;

import com.google.gson.Gson;
import com.test.testStefanini.model.ProductCart;
import com.test.testStefanini.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ProductCartDAO {

    @Autowired
    private ProductCartRepository productCartRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(String dataProduct) {

        Gson gson = new Gson();

        ProductCart productCart = gson.fromJson(dataProduct, ProductCart.class);

        em.createNativeQuery("INSERT INTO product_cart(id_user, id_product) VALUES(?,?)")
        .setParameter(1, productCart.getId_user())
        .setParameter(2, productCart.getId_product())
        .executeUpdate();
    }

    @Transactional
    public List<Object> getProductsCart(int idUser) {

        return em.createNativeQuery("SELECT p.id, p.product_name, p.product_description, p.price, COUNT(p.id)\n" +
                "FROM test_stefanini.product_cart pc\n" +
                "INNER JOIN test_stefanini.products p ON p.id=pc.id_product\n" +
                "WHERE pc.id_user= ? \n" +
                "GROUP BY pc.id_product;")
                .setParameter(1, idUser)
                .getResultList();
    }

    @Transactional
    public ResponseEntity delete(int id) {

        em.createNativeQuery("DELETE FROM product_cart WHERE id_product = ?")
                .setParameter(1, id)
                .executeUpdate();

        return ResponseEntity.ok().build();
    }
}
