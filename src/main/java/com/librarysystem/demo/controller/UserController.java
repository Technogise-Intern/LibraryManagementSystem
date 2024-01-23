package com.librarysystem.demo.controller;

import com.librarysystem.demo.service.UserService;
import com.librarysystem.demo.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer uid) {
//        return userService.getUser();
        return null;
    }

}
