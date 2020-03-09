package com.test.testStefanini.dao;

import com.google.gson.Gson;
import com.test.testStefanini.model.Users;
import com.test.testStefanini.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UsersDAO {

    @Autowired
    private UsersRepository usersRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Users> validateLogin(String users) {

        TypedQuery<Users> queryUsers = em.createNamedQuery("loginUser", Users.class);

        Gson gson = new Gson();
        

        Users userData = gson.fromJson(users, Users.class);

        queryUsers.setParameter("user_name", userData.getUser_name());
        queryUsers.setParameter("user_password", userData.getUser_password());

        List<Users> resultList = queryUsers.getResultList();


        return resultList;
    }

    @Transactional
    public ResponseEntity save(String dataProduct) {

        Gson gson = new Gson();

        Users users = gson.fromJson(dataProduct, Users.class);

        if(!validateInputs(users)) {
            return ResponseEntity.notFound().build();
        }

        em.createNativeQuery("INSERT INTO users(name, last_name, email, user_name, user_password) VALUES(?,?,?,?,?)")
                .setParameter(1, users.getName())
                .setParameter(2, users.getLast_name())
                .setParameter(3, users.getEmail())
                .setParameter(4, users.getUser_name())
                .setParameter(5, users.getUser_password())
                .executeUpdate();

        return ResponseEntity.ok().body(users);
    }

    private boolean validateInputs(Users users) {

        if(users.getUser_name().equals("")) {
            return false;
        } else if(users.getUser_password().equals("")) {
            return false;
        } else if(users.getEmail().equals("")) {
            return false;
        } else if(users.getLast_name().equals("")) {
            return false;
        } else if(users.getName().equals("")) {
            return false;
        }

        return true;
    }
}
