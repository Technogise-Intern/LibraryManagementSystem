package com.librarysystem.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

public class User {

    void testGettersAndSetters() {
        Book book = new Book();
        String expectedBookName = "Test Book";
        String expectedAuthorName = "Test Author";
        UUID expectedId = UUID.randomUUID();

        book.setBookName(expectedBookName);
        book.setAuthorName(expectedAuthorName);
        book.setId(expectedId);

        assertEquals(expectedBookName, book.getBookName());
        assertEquals(expectedAuthorName, book.getAuthorName());
        assertEquals(expectedId, book.getBookId());
    }

}
