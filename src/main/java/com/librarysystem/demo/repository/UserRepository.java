package com.librarysystem.demo.repository;

import com.librarysystem.demo.model.User;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    static Connection connection;

    public static User create(User user) throws SQLException {
        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } else {
            System.out.println("Failed to Connect");
        }
        return user;
    }

    public static String login(User user) throws SQLException {
        connection = DatabaseConfig.makeConnection();

        String token = "";
        String secretKey = "yourSecretKey";
        long expirationTimeMillis = System.currentTimeMillis() + 3600000;

        if (connection != null) {
            String query = "select * from users where password = ?";

            PreparedStatement loginStatement = connection.prepareStatement(query);
            loginStatement.setString(1, user.getPassword());

            ResultSet resultSet = loginStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("Generated JWT: " + token);

                System.out.println(resultSet.getString("username"));
                System.out.println(user.getUsername() + " Logged in");
            } else {
                System.out.println("Invalid credentials");
            }

        } else {
            System.out.println("Something went wrong!");
        }
        return token;
    }

    public static List<Book> getUserBooks(User user) {
        return user.borrowedBooks;
    }
}
