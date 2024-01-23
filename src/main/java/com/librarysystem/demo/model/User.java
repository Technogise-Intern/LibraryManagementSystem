package com.librarysystem.demo.model;

import java.awt.print.Book;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(unique=true)
    private String username;
    
    private String password;

    private String token;

    @OneToMany(mappedBy = "user")
    private List<Book> borrowedBooks;

}