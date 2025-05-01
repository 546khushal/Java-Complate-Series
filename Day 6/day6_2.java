/**In the day-5 program, make the Emp class as an abstract class. Add calculateSalary as abstract 
function. Try to create object of this class.  */


// Demonstrating Polymorphism and Abstract Classes in Account hierarchy
abstract class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Abstract method for calculating interest or overdraft usage
    public abstract String accountInfo();

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Balance: " + balance;
    }

    public void showDetails() {
        System.out.println(getDetails());
    }
}

class SavingAccount extends Account {
    private double rateOfInterest;

    public SavingAccount(int id, String name, double balance, double rateOfInterest) {
        super(id, name, balance);
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public String accountInfo() {
        return "Savings Account with Interest Rate: " + rateOfInterest + "%";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Rate of Interest: " + rateOfInterest;
    }
}

class CurrentAccount extends Account {
    private double overDraftLimit;

    public CurrentAccount(int id, String name, double balance, double overDraftLimit) {
        super(id, name, balance);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public String accountInfo() {
        return "Current Account with Overdraft Limit: " + overDraftLimit;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Overdraft Limit: " + overDraftLimit;
    }
}

public class day6_2 {
    public static void main(String[] args) {
        // Using Account reference to point to child classes
        Account acc1 = new SavingAccount(201, "Charlie", 10000, 3.5);
        Account acc2 = new CurrentAccount(202, "Dave", 5000, 2000);

        System.out.println("Saving Account Details:");
        acc1.showDetails();
        System.out.println(acc1.accountInfo());

        System.out.println("\nCurrent Account Details:");
        acc2.showDetails();
        System.out.println(acc2.accountInfo());

        // Uncommenting the following line will cause an error because Account is abstract
        // Account acc = new Account(203, "Eve", 7000);
    }
}
