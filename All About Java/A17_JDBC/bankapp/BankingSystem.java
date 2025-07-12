package bankapp;
import java.sql.*;
import java.util.*;

public class BankingSystem {
    private static final String url = "jdbc:mysql://localhost:3306/BankingSystem";
    private static final String user = "root";
    private static final String password = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection conn = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);
            User userObj = new User(conn, sc);  // renamed to avoid conflict
            Accounts account = new Accounts(conn, sc);
            AccountManager accountManager = new AccountManager(conn, sc);

            String email;
            long account_number;

            while (true) {
                System.out.println("\n*** Welcome to Banking System ***");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice1 = sc.nextInt();

                switch (choice1) {
                    case 1:
                        userObj.register();
                        break;

                    case 2:
                        email = userObj.login();
                        if (email != null) {
                            System.out.println("\n1. Open a new Bank Account");
                            System.out.println("2. Exit");
                            System.out.print("Enter your choice: ");
                            int openAccountChoice = sc.nextInt();
                            if (openAccountChoice == 1) {
                                account_number = account.open_account(email);  // ✅ fixed reference
                                System.out.println("Account Created Successfully");
                                System.out.println("Your Account Number is: " + account_number);
                            } else {
                                break;
                            }

                            account_number = account.getAccount_number(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println("\n--- Banking Menu ---");
                                System.out.println("1. Withdraw");
                                System.out.println("2. Deposit");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. Check Balance");
                                System.out.println("5. Log out");
                                System.out.print("Enter your choice: ");
                                choice2 = sc.nextInt();

                                switch (choice2) {
                                    case 1:
                                        accountManager.debit_money(account_number);
                                        break;
                                    case 2:
                                        accountManager.credit_money(account_number);
                                        break;
                                    case 3:
                                        accountManager.transfer_money(account_number);
                                        break;
                                    case 4:
                                        accountManager.getBalance(account_number);
                                        break;
                                    case 5:
                                        System.out.println("Logging out...");
                                        break;
                                    default:
                                        System.out.println("Enter Valid Choice!");
                                }
                            }
                        } else {
                            System.out.println("Incorrect Email or Password!");
                        }
                        break;

                    case 3:
                        System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
                        System.out.println("Exiting System!");
                        return;

                    default:
                        System.out.println("Enter Valid Choice");
                        break;
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}


/*
cd "E:\MCA\sem 2\JAVA\All About Java\A17_JDBC"
javac -cp ".;lib\mysql-connector-j-9.3.0.jar" bankapp\*.java
java -cp ".;lib\mysql-connector-j-9.3.0.jar" bankapp.BankingSystem


 */