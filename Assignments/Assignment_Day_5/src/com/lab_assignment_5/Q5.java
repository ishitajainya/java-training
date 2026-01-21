package com.lab_assignment_5;
import java.io.*;
import java.util.*;

public class Q5 {

    static class FileDownloader implements Runnable {
        private final String fileUrl;
        private final Random random = new Random();

        public FileDownloader(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
            System.out.println(threadName + " - Starting download: " + fileName);
            try {
                Thread.sleep(200 + random.nextInt(301));
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(threadName + " - Completed: " + fileName);
        }
    }

    private static void createURLFile(String fileName) {
        String baseUrl = "https://www.dropbox.com/photo";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 25; i++) {
                writer.write(baseUrl + i + ".jpg");
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing URL file: " + e.getMessage());
        }
    }

    private static List<String> readURLsFromFile(String fileName) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                urls.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading URL file: " + e.getMessage());
        }
        return urls;
    }

    public static void main(String[] args) {
        String urlFile = "urls.txt";
        createURLFile(urlFile);
        List<String> urls = readURLsFromFile(urlFile);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < urls.size(); i++) {
            Thread thread = new Thread(new FileDownloader(urls.get(i)));
            thread.setName("Downloader-" + (i + 1));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) { }
        }

        System.out.println("All downloads finished!");
    }
}
