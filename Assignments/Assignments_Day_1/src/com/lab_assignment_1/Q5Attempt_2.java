package com.lab_assignment_1;

import java.util.Scanner;

public class Q5Attempt_2 {

    static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            return true;
        else
            return false;
    }

    static int getDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) {
            if (isLeapYear(year))
                return 29;
            else
                return 28;
        }

        return -1;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter day: ");
            int day = sc.nextInt();

            System.out.print("Enter month: ");
            int month = sc.nextInt();

            System.out.print("Enter year: ");
            int year = sc.nextInt();

            int daysInMonth = getDaysInMonth(month, year);

            if (daysInMonth == -1 || day < 1 || day > daysInMonth) {
                System.out.println("Invalid Date");
                return;
            }

            System.out.println("Today: " + day + "/" + month + "/" + year);

            if (day == daysInMonth) {
                day = 1;

                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
            } else {
                day++;
            }

            System.out.println("Next Date: " + day + "/" + month + "/" + year);
        }
    }
}
