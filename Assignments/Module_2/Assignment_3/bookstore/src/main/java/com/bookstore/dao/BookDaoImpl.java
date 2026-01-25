package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.util.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private final EntityManager em = EntityManagerFactory.getEntityManager();

    @Override
    public void add(Book book) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(book);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new DaoException("Failed to add book", e);
        }
    }

    @Override
    public void update(Book book) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(book);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new DaoException("Failed to update book with id " + book.getId(), e);
        }
    }

    @Override
    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Book book = em.find(Book.class, id);
            if (book == null) {
                throw new DaoException("Book not found with id " + id, null);
            }
            em.remove(book);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new DaoException("Failed to delete book with id " + id, e);
        }
    }

    @Override
    public Book findById(int id) {
        try {
            return em.find(Book.class, id);
        } catch (PersistenceException e) {
            throw new DaoException("Failed to find book with id " + id, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            TypedQuery<Book> query =
                em.createQuery("SELECT b FROM Book b", Book.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new DaoException("Failed to retrieve all books", e);
        }
    }

    public void close() {
        if (em.isOpen()) em.close();
    }
}
