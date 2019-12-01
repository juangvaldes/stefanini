package com.test.testStefanini.controller;

import com.test.testStefanini.dao.UsersDAO;
import com.test.testStefanini.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class LoginController {

    @Autowired
    private UsersDAO usersDAO;

    @PostMapping(value = "/start_user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> loginUser(@RequestBody String body) {
        return usersDAO.validateLogin(body);
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody String body) {
        return usersDAO.save(body);
    }
}
