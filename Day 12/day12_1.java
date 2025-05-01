/**Write a multi-threaded program in which two threads access the common variable count which is 
initialize with 0. Both the read this count and print on console along with thread name. After  printing, 
it will increment the content of this count variable. Both thread will do this work for 5000 times. Use 
the synchronization for count increment logic.  */
class Counter {
    // Shared resource
    private int count = 0;

    // Synchronize the increment method
    public synchronized void increment() {
        count++;
    }

    public synchronized void printCount(String threadName) {
        System.out.println(threadName + " - Count: " + count);
    }
}

class CounterThread extends Thread {
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            counter.printCount(Thread.currentThread().getName());
            counter.increment();
        }
    }
}

public class day12_1 {
    public static void main(String[] args) {
        // Shared counter object
        Counter counter = new Counter();

        // Create two threads
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
