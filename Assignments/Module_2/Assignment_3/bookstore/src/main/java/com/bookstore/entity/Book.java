package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")  // Maps Book entity to the "books" table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int id;

    @Column(length = 20, nullable = false, unique = true)
    private String isbn;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    private double price;

    public Book() {}

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Book [id=" + id 
                + ", isbn=" + isbn 
                + ", title=" + title 
                + ", author=" + author 
                + ", price=" + price + "]";
    }
}
