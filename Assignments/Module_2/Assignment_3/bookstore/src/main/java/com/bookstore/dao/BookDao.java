package com.bookstore.dao;
import com.bookstore.entity.Book;
import java.util.List;

public interface BookDao {

    void add(Book book);
    void update(Book book);
    void delete(int id);
    Book findById(int id);
    List<Book> findAll();
}
