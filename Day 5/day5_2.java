// Account Hierarchy with SavingAccount and CurrentAccount classes
class Account {
    private int id;
    private String name;
    private double balance;

    // Default constructor
    public Account() {
        this.id = 0;
        this.name = "Unknown";
        this.balance = 0.0;
    }

    // Parameterized constructor
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Get details
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Balance: " + balance;
    }

    // Show details
    public void showDetails() {
        System.out.println(getDetails());
    }
}

// SavingAccount inherits Account
class SavingAccount extends Account {
    private double rateOfInterest;

    // Default constructor
    public SavingAccount() {
        super();
        this.rateOfInterest = 0.0;
    }

    // Parameterized constructor
    public SavingAccount(int id, String name, double balance, double rateOfInterest) {
        super(id, name, balance);
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Rate of Interest: " + rateOfInterest;
    }
}

// CurrentAccount inherits Account
class CurrentAccount extends Account {
    private double overDraftLimit;

    // Default constructor
    public CurrentAccount() {
        super();
        this.overDraftLimit = 0.0;
    }

    // Parameterized constructor
    public CurrentAccount(int id, String name, double balance, double overDraftLimit) {
        super(id, name, balance);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Overdraft Limit: " + overDraftLimit;
    }
}

public class day5_2 {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(201, "Charlie", 10000, 3.5);
        CurrentAccount currentAccount = new CurrentAccount(202, "Dave", 5000, 2000);

        System.out.println("Saving Account Details:");
        savingAccount.showDetails();

        System.out.println("\nCurrent Account Details:");
        currentAccount.showDetails();
    }
}
