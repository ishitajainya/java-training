package com.lab_assignment_2.q2;

public class Book {
    private String bookTitle;
    private String author;
    private String ISBN;
    private int numOfCopies;

    public Book(String bookTitle, String author, String ISBN, int numOfCopies) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
        setNumOfCopies(numOfCopies); 
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        if (numOfCopies >= 0) {
            this.numOfCopies = numOfCopies;
        } else {
            this.numOfCopies = 0;
            System.out.println("Quantity cannot be negative. Set to 0.");
        }
    }

    public void display() {
        System.out.println("Title: " + bookTitle + " – Author: " + author + 
                           " – ISBN: " + ISBN + " – Quantity: " + numOfCopies);
    }
}
