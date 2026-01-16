package com.lab_assignment_1;
import java.util.Scanner;

public class Q5Attemp_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int day, month, year;
        int daysInMonth = 0;

        System.out.print("Enter day: ");
        day = sc.nextInt();

        System.out.print("Enter month: ");
        month = sc.nextInt();

        System.out.print("Enter year: ");
        year = sc.nextInt();

        if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12) {
            daysInMonth = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else {
            System.out.println("Invalid Date");
            sc.close();
            return;
        }

        if (day < 1 || day > daysInMonth) {
            System.out.println("Invalid Date");
            sc.close();
            return;
        }

        System.out.println("Today: " + day + "/" + month + "/" + year);

        if (day < daysInMonth) {
            day = day + 1;
        } else {
            day = 1;
            if (month < 12) {
                month = month + 1;
            } else {
                month = 1;
                year = year + 1;
            }
        }

        System.out.println("Next Date: " + day + "/" + month + "/" + year);
        sc.close();
    }
}
