package com.lab_assignment_3.Q5;

public class Q5 {
    public static void main(String[] args) {
        try {
            UserRegistration.registerUser("Rohit", "India");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }

        try {
            UserRegistration.registerUser("John", "USA");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}
