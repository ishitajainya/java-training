package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.util.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(book);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Book book = em.find(Book.class, id);
            if (book != null) em.remove(book);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public void close() {
        if (em.isOpen()) em.close();
    }
}
