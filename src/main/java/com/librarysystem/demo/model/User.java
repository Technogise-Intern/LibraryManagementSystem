package com.librarysystem.demo.model;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String username;
    private String password;
    private UUID id;

    private List<Book> borrowedBooks = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}