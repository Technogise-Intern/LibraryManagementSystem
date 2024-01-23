package com.librarysystem.demo.controller;

import com.librarysystem.demo.model.Book;
import com.librarysystem.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> viewBooks() {
        List<Book> books = libraryService.viewBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save-book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = libraryService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PostMapping("/books/{bookname}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable String bookname) {
        Book borrowedBook = libraryService.borrowBook(bookname);
        return ResponseEntity.ok(borrowedBook);
    }
}
