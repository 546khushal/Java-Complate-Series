class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw...");
        if (this.amount < amount) {
            System.out.println("Less balance: Waiting for deposit...");
            try {
                wait(); // Waits until notified
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.amount -= amount;
        System.out.println("Withdraw completed. Remaining balance: " + this.amount);
    }

    synchronized void deposit(int amount) {
        System.out.println("Going to deposit...");
        this.amount += amount;
        System.out.println("Deposit completed. New balance: " + this.amount);
        notify(); // Wakes up the waiting thread
    }
}

public class synchro {
    public static void main(String[] args) {
        final Customer c = new Customer();

        // Thread for withdrawal
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        // Thread for deposit
        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
}
