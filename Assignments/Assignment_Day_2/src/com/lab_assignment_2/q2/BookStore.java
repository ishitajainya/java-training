package com.lab_assignment_2.q2;

import java.util.Scanner;

public class BookStore {
    private Book[] books;
    private int count; 
    private final int MAX_BOOKS = 10;

    public BookStore() {
        books = new Book[MAX_BOOKS];
        count = 0;
    }

    public void sell(String title, int sellCount) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookTitle().equalsIgnoreCase(title)) {
                if (books[i].getNumOfCopies() >= sellCount) {
                    books[i].setNumOfCopies(books[i].getNumOfCopies() - sellCount);
                    System.out.println("Sold " + sellCount + " copies of \"" + title + "\"");
                } else {
                    System.out.println("Not enough stock for \"" + title + "\"");
                }
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\"");
    }

    public void order(String isbn, int orderCount) {
        try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i < count; i++) {
			    if (books[i].getISBN().equalsIgnoreCase(isbn)) {
			        books[i].setNumOfCopies(books[i].getNumOfCopies() + orderCount);
			        System.out.println("Ordered " + orderCount + " copies of existing book \"" + books[i].getBookTitle() + "\"");
			        return;
			    }
			}


			if (count < MAX_BOOKS) {
			    System.out.print("Enter title for new book: ");
			    String title = sc.nextLine();
			    System.out.print("Enter author for new book: ");
			    String author = sc.nextLine();

			    books[count++] = new Book(title, author, isbn, orderCount);
			    System.out.println("New book added: \"" + title + "\" with " + orderCount + " copies");
			} else {
			    System.out.println("Book store full! Cannot add new book.");
			}
		}
    }

    public void display() {
        System.out.println("------ Book Inventory ------");
        if (count == 0) {
            System.out.println("No books in inventory.");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
        System.out.println("----------------------------");
    }
}
