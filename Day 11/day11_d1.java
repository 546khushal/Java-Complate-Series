//Write a two threaded program in which first thread prints 1 to 5000 numbers and second thread prints 5000 to 1 numbers.  
// File: day11_desirable_assignment.java

class PrintNumbersAscend extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++) {
            System.out.println(i);
        }
    }
}

class PrintNumbersDescend extends Thread {
    @Override
    public void run() {
        for (int i = 5000; i >= 1; i--) {
            System.out.println(i);
        }
    }
}

public class day11_d1{
    public static void main(String[] args) {
        // Create threads
        PrintNumbersAscend thread1 = new PrintNumbersAscend();
        PrintNumbersDescend thread2 = new PrintNumbersDescend();

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
