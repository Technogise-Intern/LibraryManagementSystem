package com.librarysystem.demo.service;

import com.librarysystem.demo.model.User;
import com.librarysystem.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    public static void createUser(User user) {
        try {
            UserRepository.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String loginUser(User user) throws SQLException {
        return UserRepository.login(user);
    }

    public static List<Book> viewBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        return books;
    }

    public boolean canBorrow(User user) {
        return user.borrowedBooks.size() <= 2;
    }

    public static Book borrowBook(String username, String bookname) {

        return null;
    }

    public List<Book> getUserBooks(User user) {
        return UserRepository.getUserBooks(user);
    }

    private List<User> users;

    public UserService() {

        users = new ArrayList<>();

        User user = new User();
        user.setUsername("Aditya");
        user.setPassword("password");
        user.setId(UUID.randomUUID());

        users.add(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void login(String username, String password) {
        for (User user : users) {
            if (user.getPassword().equals(password)) {

            }
        }
    }
}
