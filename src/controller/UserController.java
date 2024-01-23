package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import model.User;
import service.*;
import view.LibraryView;

public class UserController {

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
        LibraryView.showAllBooks(books);

    }

    public Book borrowBook(String bookname) {
        return null;
    }
}
