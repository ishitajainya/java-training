package com.lab_assignment_4.q2;

public class Q2{

    public static void main(String[] args) {

        Book b1 = new Book("Java in Depth", "James Gosling");
        Book b2 = new Book("Python Basics", "Guido van Rossum");
        Book b3 = new Book("Effective Java", "Joshua Bloch");
        Book b4 = new Book("Java in Depth", "James Gosling"); 

        Book[] books = {b1, b2, b3, b4};
        BookCollection myCollection = new BookCollection("Alice", books);

        Book book1 = new Book("Java in Depth", "James Gosling");
        boolean exists = myCollection.hasBook(book1);
        System.out.println("Does 'Java in Depth' exist? " + exists);
        myCollection.sort();

        System.out.println("\nFinal Sorted Collection:");
        System.out.println(myCollection);
    }
}
