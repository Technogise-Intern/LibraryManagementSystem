package com.librarysystem.demo.controller;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

import com.librarysystem.demo.model.User;
import com.librarysystem.demo.service.UserService;

public class LibraryController {


    UserService userService = new UserService();


    public static void viewBooks() throws SQLException {
        List<Book> books = UserService.viewBooks();
    }

    public Book borrowBook(String bookname) {
        return null;
    }


    public static Book saveBook(String bookname, String authorname) throws SQLException {
        Book book = new Book();

        return book;
    }

}