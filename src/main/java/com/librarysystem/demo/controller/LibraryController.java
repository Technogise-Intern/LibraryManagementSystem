package com.librarysystem.demo.controller;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

import com.librarysystem.demo.model.User;
import com.librarysystem.demo.service.UserService;

public class LibraryController {

    private User user = new User();

    UserService userService = new UserService();

    public User createUser(String usernname, String password) {
        user.setUsername(usernname);
        user.setPassword(password);

        UserService.createUser(user);
        return user;
    }

    public String loginUser(String usernname, String password) throws SQLException {
        user.setUsername(usernname);
        user.setPassword(password);

        String userToken = UserService.loginUser(user);
        return userToken;
    }


    public static void viewBooks() throws SQLException {

        List<Book> books = UserService.viewBooks();
//        LibraryView.showAllBooks(books);

    }

    public Book borrowBook(String bookname) {
        return null;
    }

    public void getAllBooks() {

    }

    public static Book saveBook(String bookname, String authorname) throws SQLException {
        Book book = new Book();
//        book.setBookName(bookname);
//        book.setAuthorName(authorname);
//        return LibraryService.saveBook(book);
        return book;
    }

}