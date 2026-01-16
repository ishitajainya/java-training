package com.lab_assignment_2.q2;

public class Q2 {
    public static void main(String[] args) {
        BookStore store = new BookStore();


        store.order("ISBN101", 5); 
        store.order("ISBN102", 3); 

        store.display();

        store.order("ISBN101", 2);

        store.sell("Born Again on the Mountains", 1); 
        store.sell("ISBN102", 5);

        store.display();
    }
}
