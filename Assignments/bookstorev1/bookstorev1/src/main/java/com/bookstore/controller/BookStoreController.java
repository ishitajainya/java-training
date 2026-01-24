package com.bookstore.controller;

import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dto.Book;
import com.bookstore.service.BookService;
import com.bookstore.exceptions.DaoException;

import java.util.List;

public class BookStoreController {

    public static void main(String[] args) {
        BookDaoJdbcImpl bookDao = null;
        try {
            bookDao = new BookDaoJdbcImpl();
            BookService bookService = new BookService(bookDao);

            // Insert at least 5 books 
            Book book1 = new Book("9780134685991", "Effective Java", "Joshua Bloch", 550.00);
            Book book2 = new Book("9780596009205", "Head First Java", "Kathy Sierra", 450.00);
            Book book3 = new Book("9780132350884", "Clean Code", "Robert C. Martin", 600.00);
            Book book4 = new Book("9780321349606", "Java Concurrency in Practice", "Brian Goetz", 700.00);
            Book book5 = new Book("9781617294945", "Spring in Action", "Craig Walls", 650.00);

            bookService.addBook(book1);
            bookService.addBook(book2);
            bookService.addBook(book3);
            bookService.addBook(book4);
            bookService.addBook(book5);

            System.out.println("5 books added successfully!");

            // READ
            System.out.println("\nAll books in the store:");
            displayBooks(bookService.getAllBooks());

            // UPDATE
            book3.setPrice(620.00);
            int book3_id = book3.getId();
            bookService.updateBook(book3_id, book3);
            System.out.println("\nUpdated 'Clean Code' price to 620.00");

            System.out.println("\nBooks after update:");
            displayBooks(bookService.getAllBooks());

            // DELETE
            bookService.deleteBook(book2.getId());
            System.out.println("\nDeleted 'Head First Java'");

            System.out.println("\nBooks after deletion:");
            displayBooks(bookService.getAllBooks());

            // READ one book, Get one book by ID 
            Book fetchedBook = bookService.getBookById(book1.getId());
            System.out.println("\nFetched single book by ID:");
            System.out.println(fetchedBook.getId() + " | " + fetchedBook.getTitle() + " | " + fetchedBook.getAuthor() + " | " + fetchedBook.getPrice());

        } catch (DaoException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (bookDao != null) {
                try {
                    bookDao.close();
                    System.out.println("\nDatabase connection closed.");
                } catch (DaoException e) {
                    System.out.println("Failed to close database connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private static void displayBooks(List<Book> books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
