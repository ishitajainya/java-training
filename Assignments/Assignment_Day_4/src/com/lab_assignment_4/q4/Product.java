package com.lab_assignment_4.q4;


public class Product {
    int productId;
    String productName;
    double productPrice;

    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return productName + " (" + productPrice + ") ₹";
    }
}
