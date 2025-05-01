import java.util.Scanner;

// Base class for accounts
abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
        BankSystem.incrementTotalAccounts();
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);
}

// Savings Account class
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03; // 3% interest rate

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount + (amount * INTEREST_RATE);
            System.out.println("Amount deposited with interest. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
}

// Checking Account class
class CheckingAccount extends Account {
    private static final double TRANSACTION_FEE = 50; // Fixed transaction fee

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (amount + TRANSACTION_FEE) <= balance) {
            balance -= (amount + TRANSACTION_FEE);
            System.out.println("Amount withdrawn with transaction fee. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
}

// Main class for the Banking System
public class BankSystem {
    private static int totalAccounts = 0;

    public static void incrementTotalAccounts() {
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Total Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter initial balance for Savings Account: ");
                    double savingsBalance = scanner.nextDouble();
                    account = new SavingsAccount(savingsBalance);
                    System.out.println("Savings Account created successfully.");
                    break;

                case 2:
                    System.out.print("Enter initial balance for Checking Account: ");
                    double checkingBalance = scanner.nextDouble();
                    account = new CheckingAccount(checkingBalance);
                    System.out.println("Checking Account created successfully.");
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 5:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.println("Current Balance: " + account.getBalance());
                    }
                    break;

                case 6:
                    System.out.println("Total Accounts: " + getTotalAccounts());
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
