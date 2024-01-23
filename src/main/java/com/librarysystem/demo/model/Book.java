package com.librarysystem.demo.model;

import java.util.UUID;

public class Book {
    private String bookName;
    private String authorName;
    private UUID id;


    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public UUID getBookId() {
        return id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}