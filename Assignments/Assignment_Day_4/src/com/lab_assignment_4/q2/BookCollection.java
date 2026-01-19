package com.lab_assignment_4.q2;
import java.util.Arrays;
import java.util.Comparator;

public class BookCollection {

    private String ownerName;
    private Book[] books;

    public BookCollection(String ownerName, Book[] books) {
        this.ownerName = ownerName;
        this.books = books;
    }

    public boolean hasBook(Book b) {
        if (b == null) return false;

        for (Book book : books) {
            if (book != null && book.equals(b)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {

                if (b1 == null && b2 == null) return 0;
                if (b1 == null) return 1;
                if (b2 == null) return -1;

                String t1 = b1.getTitle();
                String t2 = b2.getTitle();

                if (t1 == null && t2 == null) {
                    // move to author comparison
                } else if (t1 == null) {
                    return 1;
                } else if (t2 == null) {
                    return -1;
                } else {
                    int titleCompare = t1.compareToIgnoreCase(t2);
                    if (titleCompare != 0) {
                        return titleCompare;
                    }
                }

                String a1 = b1.getAuthor();
                String a2 = b2.getAuthor();

                if (a1 == null && a2 == null) return 0;
                if (a1 == null) return 1;
                if (a2 == null) return -1;

                return a1.compareToIgnoreCase(a2);
            }
        });
    }

    @Override
    public String toString() {
        String result = "Book Collection of " + ownerName + ":\n";

        for (Book book : books) {
            if (book != null) {
                result = result + " - " + book + "\n";
            }
        }

        return result;
    }

}

