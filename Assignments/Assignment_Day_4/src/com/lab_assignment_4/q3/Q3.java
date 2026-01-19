package com.lab_assignment_4.q3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        List<Double> values = new ArrayList<>();
        String fileName = "src\\com\\lab_assignment_4\\q3\\data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    double number = Double.parseDouble(line.trim());
                    values.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number skipped: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Handle empty file scenario
        if (values.isEmpty()) {
            System.out.println("No valid double values found in the file.");
            return;
        }

        // Find the largest value
        double max = values.get(0);
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("Largest value: " + max);
    }
}
