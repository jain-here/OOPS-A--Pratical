// Exception Handling in Banking Application
// Demonstrates nested try-catch-finally blocks for runtime exceptions

import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }
        balance -= amount;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankingApplication {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║        BANKING APPLICATION - EXCEPTION HANDLING            ║");
        System.out.println("║        Nested Try-Catch-Finally Demonstration              ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        Account[] accounts = new Account[3];
        accounts[0] = new Account("ACC001", "John Doe", 5000.0);
        accounts[1] = new Account("ACC002", "Jane Smith", 7500.0);
        accounts[2] = new Account("ACC003", "Bob Johnson", 3000.0);
        
        // Scenario 1: Successful operation
        System.out.println("═══ Scenario 1: Successful Balance Check ═══");
        try {
            Account account = accounts[0];
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Current Balance: $" + account.getBalance());
            System.out.println("✓ Operation successful");
        } catch (NullPointerException e) {
            System.out.println("❌ Error: Account not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: Invalid account index");
        } finally {
            System.out.println("→ Transaction logging completed");
        }
        System.out.println();
        
        // Scenario 2: NullPointerException
        System.out.println("═══ Scenario 2: Null Pointer Exception ═══");
        try {
            Account nullAccount = null;
            System.out.println("Attempting to access null account...");
            double balance = nullAccount.getBalance();  // Will throw NullPointerException
            System.out.println("Balance: $" + balance);
        } catch (NullPointerException e) {
            System.out.println("❌ Error: Account object is null");
            System.out.println("   Exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("→ Error logged for debugging");
        }
        System.out.println();
        
        // Scenario 3: ArrayIndexOutOfBoundsException
        System.out.println("═══ Scenario 3: Array Index Out of Bounds ═══");
        try {
            System.out.println("Attempting to access account at invalid index...");
            Account invalidAccount = accounts[10];  // Will throw ArrayIndexOutOfBoundsException
            System.out.println("Account: " + invalidAccount.getAccountHolder());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: Invalid account index (index: 10, size: " + accounts.length + ")");
            System.out.println("   Exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("→ Security alert sent");
        }
        System.out.println();
        
        // Scenario 4: ArithmeticException
        System.out.println("═══ Scenario 4: Arithmetic Exception ═══");
        try {
            int accountCount = accounts.length;
            int divisor = 0;
            System.out.println("Calculating average balance...");
            int average = accountCount / divisor;  // Will throw ArithmeticException
            System.out.println("Average: " + average);
        } catch (ArithmeticException e) {
            System.out.println("❌ Error: Cannot divide by zero");
            System.out.println("   Exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("→ Calculation module reset");
        }
        System.out.println();
        
        // Scenario 5: Nested try-catch blocks for fund transfer
        System.out.println("═══ Scenario 5: Fund Transfer with Nested Exception Handling ═══");
        try {
            Account sourceAccount = accounts[0];
            System.out.println("Source Account: " + sourceAccount.getAccountHolder());
            System.out.println("Initial Balance: $" + sourceAccount.getBalance());
            
            try {
                double transferAmount = 2000.0;
                System.out.println("Transferring $" + transferAmount + "...");
                sourceAccount.withdraw(transferAmount);
                
                // Simulate receiving account
                try {
                    Account targetAccount = accounts[1];
                    targetAccount.deposit(transferAmount);
                    System.out.println("✓ Transfer successful");
                    System.out.println("New Balance: $" + sourceAccount.getBalance());
                } catch (NullPointerException e) {
                    System.out.println("❌ Error: Target account not found");
                    // Rollback
                    sourceAccount.deposit(transferAmount);
                }
                
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
            
        } catch (NullPointerException e) {
            System.out.println("❌ Error: Source account not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: Invalid account selection");
        } finally {
            System.out.println("→ Transaction record saved");
        }
        System.out.println();
        
        // Scenario 6: Multiple exception types in one catch block
        System.out.println("═══ Scenario 6: Multiple Operations with Exception Handling ═══");
        try {
            // Multiple operations that could fail
            Account acc = accounts[0];
            String holderName = acc.getAccountHolder();
            double bal = acc.getBalance();
            int calculation = (int) bal / 100;
            
            System.out.println("Account: " + holderName);
            System.out.println("Balance: $" + bal);
            System.out.println("Calculation result: " + calculation);
            System.out.println("✓ All operations successful");
            
        } catch (NullPointerException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("❌ Error occurred: " + e.getClass().getSimpleName());
            System.out.println("   Message: " + e.getMessage());
        } finally {
            System.out.println("→ Operation log entry created");
        }
        System.out.println();
        
        System.out.println("=".repeat(60));
        System.out.println("\n📖 EXCEPTION HANDLING BEST PRACTICES:\n");
        System.out.println("1. Use specific exception types before generic ones");
        System.out.println("2. Always use finally block for cleanup operations");
        System.out.println("3. Nested try-catch helps handle different error levels");
        System.out.println("4. Log exceptions for debugging and auditing");
        System.out.println("5. Provide meaningful error messages to users");
        System.out.println();
        System.out.println("✓ Benefits:");
        System.out.println("  • Prevents application crashes");
        System.out.println("  • Enables graceful error handling");
        System.out.println("  • Improves user experience");
        System.out.println("  • Facilitates debugging and maintenance");
        System.out.println("  • Ensures resource cleanup (finally block)");
    }
}
