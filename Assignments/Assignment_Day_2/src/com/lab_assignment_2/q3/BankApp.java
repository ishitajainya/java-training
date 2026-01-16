package q3;

public class BankApp {

    public static void main(String[] args) {

        // Savings Account Demo
        System.out.println("----- Savings Account -----");
        SavingsAccount sa = new SavingsAccount("Ravi", 101, 10000);

        sa.deposit(2000);
        sa.withdraw(3000);
        sa.withdraw(5000); // fails

        System.out.println("Balance with interest: ₹" + sa.getBalance());

        // Current Account Demo
        System.out.println("\n----- Current Account -----");
        CurrentAccount ca = new CurrentAccount("Amit Traders", 201, 5000,
                "TLN12345", 10000);

        ca.deposit(3000);
        ca.withdraw(10000); // allowed using overdraft
        ca.withdraw(10000); // exceeds overdraft

        System.out.println("Current Balance: ₹" + ca.getBalance());
    }
}
