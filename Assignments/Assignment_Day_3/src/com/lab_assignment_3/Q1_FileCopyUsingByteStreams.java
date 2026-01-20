package com.lab_assignment_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1_FileCopyUsingByteStreams {

    public static void main(String[] args) {
        File sourceFile = new File("image.jpg");   
        File destFile = new File("copy_image.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied using byte streams.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                System.out.println("Original file size: " + sourceFile.length() + " bytes");
                System.out.println("Copied file size:   " + destFile.length() + " bytes");

            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
