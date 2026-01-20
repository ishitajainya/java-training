package com.lab_assignment_3.Q4;
import java.io.*;
import java.util.*;

public class BookService {

    private LinkedList<Book> bookList = new LinkedList<>();
    public void loadBooksFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");

                int id = Integer.parseInt(data[0]);
                String isbn = data[1];
                String title = data[2];
                String author = data[3];
                int quantity = Integer.parseInt(data[4]);

                Book book = new Book(id, isbn, title, author, quantity);
                bookList.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book searchBook(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void sellBook(String isbn, int noOfCopies) throws NotSufficientBookException {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {

                if (book.getQuantity() < noOfCopies) {
                    throw new NotSufficientBookException("Not enough copies available");
                }

                book.setQuantity(book.getQuantity() - noOfCopies);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void purchaseBook(String isbn, int noOfCopies) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                book.setQuantity(book.getQuantity() + noOfCopies);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
