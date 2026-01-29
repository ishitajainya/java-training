package com.bookstore.dao;
import com.bookstore.entity.Book;
import java.util.List;

public interface BookDao {

    // Create a new book
    void save(Book book);

    // Update an existing book
    void update(Book book);

    // Delete a book by ID
    void delete(int id);

    // Find a book by ID
    Book findById(int id);

    // Retrieve all books
    List<Book> findAll();
}
