package com.lab_assignment_2.q3;

class CurrentAccount extends Account {

    private String tradeLicenseNumber;
    private double overdraft;

    public CurrentAccount(String name, int accountNumber, double accountBalance,
                          String tradeLicenseNumber, double overdraft) {
        super(name, accountNumber, accountBalance);
        this.setTradeLicenseNumber(tradeLicenseNumber);
        this.overdraft = overdraft;
    }

    // No interest
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount <= (accountBalance + overdraft)) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful: ₹" + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

	public String getTradeLicenseNumber() {
		return tradeLicenseNumber;
	}

	public void setTradeLicenseNumber(String tradeLicenseNumber) {
		this.tradeLicenseNumber = tradeLicenseNumber;
	}
}
