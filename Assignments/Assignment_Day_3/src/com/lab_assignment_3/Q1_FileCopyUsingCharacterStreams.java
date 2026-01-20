package com.lab_assignment_3;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q1_FileCopyUsingCharacterStreams {

    public static void main(String[] args) {
        File sourceFile = new File("src\\com\\lab_assignment_3\\source.txt");   // Text file
        File destFile = new File("src\\com\\lab_assignment_3\\copy_char.txt");

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(sourceFile);
            fw = new FileWriter(destFile);

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
            fw.flush();
            System.out.println("File copied using character streams.");

            System.out.println("Original file size: " + sourceFile.length() + " bytes");
            System.out.println("Copied file size:   " + destFile.length() + " bytes");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fr != null) fr.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
