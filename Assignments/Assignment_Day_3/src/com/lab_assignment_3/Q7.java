package com.lab_assignment_3;

import java.util.Scanner;

public class Q7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the 2 numbers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("The quotient of " + a + "/" + b + " = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        }
        finally {
            System.out.println("Inside finally block");
            sc.close();
        }
    }
}
