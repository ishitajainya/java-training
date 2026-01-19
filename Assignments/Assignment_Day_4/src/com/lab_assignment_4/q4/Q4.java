package com.lab_assignment_4.q4;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Q4 {

    public static void main(String[] args) {
        Comparator<Product> priceAscending =
                (p1, p2) -> Double.compare(p1.productPrice, p2.productPrice);

        PriorityQueue<Product> queue = new PriorityQueue<>(priceAscending);

        queue.add(new Product(101, "Pen", 10.0));
        queue.add(new Product(102, "Notebook", 25.0));
        queue.add(new Product(103, "Bag", 400.0));
        queue.add(new Product(104, "Laptop", 60000.0));
        queue.add(new Product(105, "Mouse", 500.0));


        while (!queue.isEmpty()) {
            System.out.println("Processing product: " + queue.poll());
        }
    }
}
