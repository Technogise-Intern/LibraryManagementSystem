package com.librarysystem.demo.controller;

import com.librarysystem.demo.service.UserService;
import com.librarysystem.demo.model.User;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    private User user = new User();

    public User createUser(String usernname, String password) {
        user.setUsername(usernname);
        user.setPassword(password);

        UserService.createUser(user);
        return user;
    }

    public String loginUser(String usernname, String password) throws SQLException {
        user.setUsername(usernname);
        user.setPassword(password);

        String userToken = UserService.loginUser(usernname, password);
        return userToken;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer uid) {
        return null;
    }

}
