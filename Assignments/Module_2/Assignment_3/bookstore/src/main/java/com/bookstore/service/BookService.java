package com.bookstore.service;


import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImpl;
import com.bookstore.entity.Book;

import java.util.List;

public class BookService {

    private final BookDao bookDao = new BookDaoImpl();

    public void addBook(Book book) {
        if (book.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        if (book.getId() <= 0) {
            throw new IllegalArgumentException("Invalid Book ID");
        }
        bookDao.update(book);
    }

    public void deleteBook(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid Book ID");
        }
        bookDao.delete(id);
    }

    public Book getBookById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid Book ID");
        }
        return bookDao.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


}
