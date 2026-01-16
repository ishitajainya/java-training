package q3;

class SavingsAccount extends Account {

    private final double interest = 5; // 5%
    private final double minimumBalance = 5000;

    public SavingsAccount(String name, int accountNumber, double accountBalance) {
        super(name, accountNumber, accountBalance);
    }

    public double getBalance() {
        return accountBalance + (accountBalance * interest / 100);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > accountBalance) {
            System.out.println("Withdrawal exceeds available balance.");
        } 
        else if ((accountBalance - amount) < minimumBalance) {
            System.out.println("Withdrawal denied. Minimum balance of ₹5000 must be maintained.");
        } 
        else {
            accountBalance -= amount;
            System.out.println("Withdrawal successful: ₹" + amount);
        }
    }
}
