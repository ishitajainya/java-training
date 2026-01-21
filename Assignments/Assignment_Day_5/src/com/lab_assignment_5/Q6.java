package com.lab_assignment_5;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addAmount(double amount) {
        balance += amount;
    }

    public void subtractAmount(double amount) {
        balance -= amount;
    }
}

class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
            System.out.println(Thread.currentThread().getName() +
                    " withdrew 1000 | Balance: " + account.getBalance());
        }
    }
}

class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
            System.out.println(Thread.currentThread().getName() +
                    " deposited 1000 | Balance: " + account.getBalance());
        }
    }
}

public class Q6 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(10000);

        Thread bank = new Thread(new Bank(account), "Bank");
        Thread company = new Thread(new Company(account), "Company");

        bank.start();
        company.start();

        bank.join();
        company.join();

        System.out.println("Final Balance: " + account.getBalance());
    }
}
