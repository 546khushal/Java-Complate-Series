/**Write a multi-threaded program in which two threads prints 1 to 5000 numbers by extending Thread 
class. */


class PrintNumbers extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++) {
            System.out.println(i);
        }
    }
}

public class day11_2 {
    public static void main(String[] args) {
        // Create two threads
        PrintNumbers thread1 = new PrintNumbers();
        PrintNumbers thread2 = new PrintNumbers();

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
