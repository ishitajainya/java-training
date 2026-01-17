package com.lab_assignment_2.q3;


class Account {
    protected String name;
    protected int accountNumber;
    protected double accountBalance;

    public Account(String name, int accountNumber, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // To be overridden
    public void withdraw(double amount) {
        System.out.println("Withdraw method not implemented.");
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
