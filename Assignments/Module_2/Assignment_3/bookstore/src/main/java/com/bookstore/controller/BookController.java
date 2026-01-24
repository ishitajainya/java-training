package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

import java.util.List;

public class BookController {

    public static void main(String[] args) {
        BookService bookService = new BookService();

        // Add books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 45.0);
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra", 30.0);
        bookService.addBook(book1);
        bookService.addBook(book2);

        // Update a book
        book1.setPrice(50.0);
        bookService.updateBook(book1);

        // Delete a book
        bookService.deleteBook(book2.getId());

        // Find by ID
        Book found = bookService.getBookById(book1.getId());
        System.out.println("Found Book: " + found);

        // List all books
        List<Book> books = bookService.getAllBooks();
        System.out.println("All Books:");
        for (Book b : books) {
            System.out.println(b);
        }

    }
}
