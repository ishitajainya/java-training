package com.lab_assignment_3.Q4;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int quantity;

    public Book(int id, String isbn, String title, String author, int quantity) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + " | " + isbn + " | " + title + " | " + author + " | Qty: " + quantity;
    }
}
