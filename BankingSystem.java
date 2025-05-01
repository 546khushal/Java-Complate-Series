import java.util.*;
//Abstract class BankAccount
abstract class BankAccount{
    private String acNumber;
    private String acHolderName;
    private double balance;
    //Constructor
    public BankAccount(String acNumber,String acHolderName,double balance){
        this.acNumber=acNumber;
        this.acHolderName=acHolderName;
        this.balance=balance;
    }
    public String getAcNumber(){
        return acNumber;
    }
    public String getAcHolderName(){
        return acHolderName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void deposite(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposite Amount : "+amount);
            System.out.println("New Balance : "+ balance);
        }else{
            System.out.println("Invalid Amount");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdraw Amount : "+amount);
            System.out.println("New Balance : "+ balance);
        }else{
            System.out.println("Insufficient Amount");
        }
    }
    public abstract void displayDetails();
}

class SavingsAccount extends BankAccount{
    private double intrestRate;
    public SavingsAccount(String acNumber,String acHolderName,double balance,double intrestRate){
        super(acNumber,acHolderName,balance);
        this.intrestRate=intrestRate;
    }
    public double CalculateIntrest(){
        return getBalance()*(intrestRate/100);
    }
    @Override
    public void displayDetails(){
        System.out.println("Account Type: Saving Account");
        System.out.println("Account Number: "+ getAcNumber());
        System.out.println("Account Holder: "+ getAcHolderName());
        System.out.println("Balance: "+ getBalance());
        System.out.println("Intrest Rate: "+ intrestRate+" %");
        System.out.println("Final Balance After Intrest: "+ CalculateIntrest());
    }

}



class CurrentAccount extends BankAccount{
    private double OverDraftLimit;
    public CurrentAccount(String acNumber,String acHolderName,double balance,double OverDraftLimit){
        super(acNumber,acHolderName,balance);
        this.OverDraftLimit=OverDraftLimit;
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=getBalance()+OverDraftLimit){
            setBalance(getBalance()-amount);
            System.out.println("Withdraw Amount : "+amount);
            System.out.println("New Balance : "+ getBalance());
        }else{
            System.out.println("Withdraw Exceeds Overdraft Limit or Invalid Amount");
        }
    }
    @Override
    public void displayDetails(){
        System.out.println("Account Type: Current Account");
        System.out.println("Account Number: "+ getAcNumber());
        System.out.println("Account Holder: "+ getAcHolderName());
        System.out.println("Balance: "+ getBalance());
        System.out.println("OverDraft Limit: "+ OverDraftLimit);
    }

}

public class BankingSystem{
    private static final int MAX_ACCOUNT=100;
    private static BankAccount[] account=new BankAccount[MAX_ACCOUNT];
    private static int accountCount=0;
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("\nBanking ManageMent System");
            System.out.println("1. Create Saving Account ");
            System.out.println("2. Create Current Account ");
            System.out.println("3. view Account Details ");
            System.out.println("4. Deposite ");
            System.out.println("5. Withdraw ");
            System.out.println("6. Exit ");
            System.out.println("\n Enter Your Choice ");
            int ch= sc.nextInt();
            switch(ch){
                case 1:
                    CreateSavingAccount();
                    break;
                case 2:
                    CreateCurrentAccount();
                    break;
                case 3:
                    ViewAccount();
                    break;
                case 4:
                    Deposite();
                    break;
                case 5:
                    Withdraw();
                    break;
                case 6:
                    System.out.println("Thank You Bye Bye");
                    return;
                
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    public static void CreateSavingAccount(){
        if(accountCount<MAX_ACCOUNT){
            String acNumber= String.valueOf(accountCount);
            System.out.println("Account Number :"+acNumber);
            System.out.println("Enter Account Holder Name:");
            String acHolderName=sc.next();
            System.out.println("Enter Initial Balance: ");
            double balance= sc.nextDouble();
            System.out.println("Enter Intrest rate: ");
            double intrestRate= sc.nextDouble();
            account[accountCount++]=new SavingsAccount(acNumber,acHolderName,balance,intrestRate);
            System.out.println("Saving account created SuccessFully");
        }
    }
    public static void CreateCurrentAccount(){
        if(accountCount<MAX_ACCOUNT){
            String acNumber=String.valueOf(accountCount);
            System.out.println("Account Number :"+acNumber);
            System.out.println("Enter Account Holder Name:");
            String acHolderName=sc.next();
            System.out.println("Enter Initial Balance: ");
            double balance= sc.nextDouble();
            System.out.println("Enter OverDraft Limit: ");
            double OverDraftLimit= sc.nextDouble();
            account[accountCount++]=new CurrentAccount(acNumber,acHolderName,balance,OverDraftLimit);
            System.out.println("current account created SuccessFully");
        }
    }

    public static void ViewAccount(){
        System.out.println("Enter Account Number: ");
        String acNumber=sc.next();
        BankAccount account=FindAccount(acNumber);
        if(account!=null){
            account.displayDetails();
        }
        else{
            System.out.println("Account Not Found");
        }
    }
    public static void Deposite(){
        System.out.println("Enter Account Number: ");
        String acNumber=sc.next();
        BankAccount account=FindAccount(acNumber);
        if(account!=null){
            System.out.println("Enter Amount to Deposite: ");
            double  amount=sc.nextDouble();
            account.deposite(amount);
        }
        else{
            System.out.println("Account Not Found");
        }
    }
    public static void Withdraw(){
        System.out.println("Enter Account Number: ");
        String acNumber=sc.next();
        BankAccount account=FindAccount(acNumber);
        if(account!=null){
            System.out.println("Enter withdraw Amount: ");
            double  amount=sc.nextDouble();
            account.withdraw(amount);
        }
        else{
            System.out.println("Account Not Found");
        }
    }

    public static BankAccount FindAccount(String acNumber){
        for(int i=0;i<accountCount;i++){
            if(account[i].getAcNumber().equals(acNumber)){
                return account[i];
            }
        }
        return null;
    }
}