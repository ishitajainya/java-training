package com.lab_assignment_3.Q5;

public class UserRegistration {

    public static void registerUser(String username, String userCountry)
            throws InvalidCountryException {

        if (!userCountry.equalsIgnoreCase("India")) {
            throw new InvalidCountryException(
                    "User " + username + " Outside India cannot be registered");
        }

        System.out.println("User registration done successfully");
    }
}
