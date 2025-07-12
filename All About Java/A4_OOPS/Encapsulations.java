/**
 * ENCAPSULATION: Binding data (variables) and methods (functions) together as a single unit.
 * Key Principles:
 * 1. Declare fields as private (data hiding)
 * 2. Provide public getter/setter methods (controlled access)
 * 3. Add validation in setters (data integrity)
 * 4. Optionally add access logging/security
 
Binding (or wrapping) code and data together into a single unit is known as encapsulation. 
For example: capsule, it is wrapped with different medicines. 

 */
/*



public class Encapsulations {
    private String secret; // Private data

    // Getter (accessor)
    public String getSecret() {
        return this.secret;
    }

    // Setter (mutator) with validation
    public void setSecret(String newSecret) {
        if(newSecret != null) {
            this.secret = newSecret;
        }
    }

    public static void main(String[] args) {
        Encapsulations obj = new Encapsulations();
        obj.setSecret("My Password");
        System.out.println(obj.getSecret());
    }
}
*/
//BankAccount
public class Encapsulations {
    // 1. Private fields (data hiding)
    private String accountNumber;
    private double balance;
    private String ownerName;
    
    // 2. Constructor for initializing encapsulated data
    public Encapsulations(String accountNumber, double initialBalance, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.ownerName = ownerName;
    }
    
    // 3. Public getters (controlled read access)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    // 4. Public setters with validation (controlled write access)
    public void setOwnerName(String newName) {
        if(newName != null && !newName.trim().isEmpty()) {
            this.ownerName = newName;
        } else {
            System.out.println("Invalid name provided");
        }
    }
    
    // 5. Business methods that work with encapsulated data
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    // 6. Main method to demonstrate functionality
    public static void main(String[] args) {
        Encapsulations account = new Encapsulations("123456789", 1000.0, "John Doe");
        
        // Accessing data through getters
        System.out.println("Account Holder: " + account.getOwnerName());//Account Holder: John Doe
        System.out.println("Initial Balance: " + account.getBalance());//Initial Balance: 1000.0
        
        // Modifying data through controlled methods
        account.setOwnerName("John B. Doe");
        account.deposit(500.0);//Deposit successful. New balance: 1500.0 
        account.withdraw(200.0);//Withdrawal successful. New balance: 1300.0 
        
        // Trying to set invalid data
        account.setOwnerName("");  //Invalid name provided
        account.withdraw(2000.0); //Invalid withdrawal amount or insufficient funds
        
        // Direct access would cause error (uncomment to test)
        // account.balance = 1000000; // Error: balance is private
    }
}