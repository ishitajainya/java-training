package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;

public class BookService {

    private BookDao bookDao;
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book addBook(Book book) throws Exception {

        validateBook(book);

        try {
            return bookDao.addBook(book);
        } catch (DaoException e) {
            throw new Exception("Unable to add book. Please try again later.", e);
        }
    }

    public List<Book> getAllBooks() throws Exception {
        try {
            return bookDao.getAllBooks();
        } catch (DaoException e) {
            throw new Exception("Unable to fetch books at the moment.", e);
        }
    }

    public Book getBookById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }

        try {
            return bookDao.getBookById(id);
        } catch (DaoException e) {
            throw new Exception("Book not found with ID: " + id, e);
        }
    }

    public void updateBook(int id, Book book) throws Exception {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }

        validateBook(book);

        try {
            bookDao.updateBook(id, book);
        } catch (DaoException e) {
            throw new Exception("Unable to update book.", e);
        }
    }

    public void deleteBook(int id) throws Exception {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }

        try {
            bookDao.deleteBook(id);
        } catch (DaoException e) {
            throw new Exception("Unable to delete book.", e);
        }
    }

    private void validateBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be empty");
        }

        if (book.getPrice() <= 0) {
            throw new IllegalArgumentException("Book price must be greater than zero");
        }
    }
}
