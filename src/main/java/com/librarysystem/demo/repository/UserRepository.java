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

    private static User user;

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

    public static User loginUser(String username, String bookname) throws SQLException {
        connection = DatabaseConfig.makeConnection();
        if (connection != null) {
            String query = "select * from users where password = ?";

            PreparedStatement loginStatement = connection.prepareStatement(query);
            loginStatement.setString(1, user.getPassword());

            ResultSet resultSet = loginStatement.executeQuery();

            if (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
            } else {
                return null;
            }

        } else {
            System.out.println("Something went wrong!");
        }
        return user;
    }

}
