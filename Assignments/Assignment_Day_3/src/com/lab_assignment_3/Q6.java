package com.lab_assignment_3;

//Custom Exception
class InvalidAgeException extends Exception {
	 public InvalidAgeException(String message) {
	     super(message);
	 }
}

public class Q6{
	 static void validateAge(int age) throws InvalidAgeException {
	     if (age < 18 || age >= 60) {
	         throw new InvalidAgeException("Age must be between 18 and 59");
	     }
	 }

	 public static void main(String[] args) {
	
	     try {
	         if (args.length != 2) {
	             System.out.println("Usage: java ValidateNameAge <Name> <Age>");
	             return;
	         }
	
	         String name = args[0];
	         int age = Integer.parseInt(args[1]);
	
	         validateAge(age);
	         System.out.println("Name: " + name + ", Age: " + age);
	
	     } catch (InvalidAgeException e) {
	         System.out.println("InvalidAgeException: " + e.getMessage());
	     } catch (NumberFormatException e) {
	         System.out.println("Age must be a valid integer");
	     }
	 }
}
