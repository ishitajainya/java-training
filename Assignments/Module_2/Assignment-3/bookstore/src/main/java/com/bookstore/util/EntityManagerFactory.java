package com.bookstore.util;

import jakarta.persistence.EntityManager;

public class EntityManagerFactory {

    private static final jakarta.persistence.EntityManagerFactory emf =
            jakarta.persistence.Persistence.createEntityManagerFactory("BookPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
