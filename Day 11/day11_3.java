// Write a multi-threaded program in which two threads prints 1 to 5000 numbers by implementing Runnable interface. 

class PrintNumbersRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++) {
            System.out.println(i);
        }
    }
}

public class day11_3 {
    public static void main(String[] args) {
        // Create Runnable instance
        PrintNumbersRunnable task = new PrintNumbersRunnable();

        // Create threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
