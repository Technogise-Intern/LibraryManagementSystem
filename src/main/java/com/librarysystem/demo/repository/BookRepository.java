package com.librarysystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    
    
}
