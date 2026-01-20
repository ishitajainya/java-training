package com.lab_assignment_3.Q4;

public class Q4 {
    public static void main(String[] args) {

        BookService service = new BookService();

        // Load data from file
        service.loadBooksFromFile("src\\com\\lab_assignment_3\\Q4\\data.txt");

        // Display all books
        System.out.println("Initial Book List:");
        service.displayBooks();

        // Search book
        System.out.println("\nSearching book with ID 121:");
        Book b = service.searchBook(121);
        System.out.println(b != null ? b : "Book not found");

        // Sell book
        try {
            service.sellBook("A234", 2);
            System.out.println("\nAfter selling books:");
            service.displayBooks();
        } catch (NotSufficientBookException e) {
            System.out.println(e.getMessage());
        }

        // Purchase book
        service.purchaseBook("A234", 5);
        System.out.println("\nAfter purchasing books:");
        service.displayBooks();
    }
}
