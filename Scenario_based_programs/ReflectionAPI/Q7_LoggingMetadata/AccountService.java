// Banking Account Service with loggable methods
// Demonstrates methods annotated for audit logging

public class AccountService {
    
    @Loggable(message = "Deposit operation initiated")
    public void deposit(String accountNumber, double amount) {
        System.out.println("  → Depositing $" + amount + " to account " + accountNumber);
        System.out.println("  → New balance: $" + (amount + 1000)); // Simulated
    }
    
    @Loggable(message = "Withdrawal operation initiated")
    public void withdraw(String accountNumber, double amount) {
        System.out.println("  → Withdrawing $" + amount + " from account " + accountNumber);
        System.out.println("  → Remaining balance: $" + (1000 - amount)); // Simulated
    }
    
    @Loggable(message = "Fund transfer operation initiated")
    public void transfer(String fromAccount, String toAccount, double amount) {
        System.out.println("  → Transferring $" + amount + " from " + fromAccount + " to " + toAccount);
        System.out.println("  → Transfer completed successfully");
    }
    
    @Loggable(message = "Account balance inquiry")
    public double checkBalance(String accountNumber) {
        System.out.println("  → Retrieving balance for account " + accountNumber);
        return 5000.00; // Simulated balance
    }
    
    @Loggable(message = "Account closure operation initiated")
    public void closeAccount(String accountNumber, String reason) {
        System.out.println("  → Closing account " + accountNumber);
        System.out.println("  → Reason: " + reason);
        System.out.println("  → Account closed successfully");
    }
    
    @Loggable(message = "Interest calculation performed")
    public double calculateInterest(String accountNumber, double rate) {
        double balance = 5000.00; // Simulated
        double interest = balance * rate / 100;
        System.out.println("  → Calculated interest: $" + interest);
        return interest;
    }
    
    // Method without logging annotation
    public void internalCheck() {
        System.out.println("  → Internal system check (not logged)");
    }
}
