package com.bookstore.dao;


import java.util.List;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;

public interface BookDao {

    List<Book> getAllBooks() throws DaoException;

    Book addBook(Book book) throws DaoException;

    void deleteBook(int id) throws DaoException;

    void updateBook(int id, Book book) throws DaoException;

    Book getBookById(int id) throws DaoException;
}
