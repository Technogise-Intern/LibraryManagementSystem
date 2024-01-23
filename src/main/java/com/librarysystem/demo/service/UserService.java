package com.librarysystem.demo.service;

import com.librarysystem.demo.model.User;
import com.librarysystem.demo.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private static User user;
    private final static String secretKey = "yourSecretKey";
    private static long expirationTimeMillis = System.currentTimeMillis() + 3600000;

    
    public static void createUser(User user) {
        try {
            UserRepository.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String loginUser(String username, String bookname) throws SQLException {
        user = UserRepository.loginUser(username, bookname);
        return generateJWTToken();
    }

    public static String generateJWTToken() {
        String token = String.valueOf(
                Jwts.builder()
                        .setHeaderParam("typ", "JWT")
                        .signWith(SignatureAlgorithm.RS256, secretKey)
                        .setExpiration(new Date(expirationTimeMillis))
                        .setSubject(user.getUsername()).compact());
        return token;
    }

    public static List<Book> viewBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        return books;
    }

    public boolean canBorrow(User user) {
        // return user.borrowedBooks.size() <= 2;
        return false;
    }

    public static Book borrowBook(String username, String bookname) {

        return null;
    }

    public List<Book> getUserBooks(User user) {
        return null;
    }
}
