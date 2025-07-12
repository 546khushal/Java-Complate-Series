/**
 * THREAD SYNCHRONIZATION
 * 
 * Synchronization is needed when multiple threads access shared resources
 * 
 * Approaches:
 * 1. Synchronized methods
 * 2. Synchronized blocks
 * 3. ReentrantLock from java.util.concurrent.locks
 

=> Synchronized method Java ka ek feature hai jo ensure karta hai ki ek time me ek hi thread kisi critical section (shared resource) ko access kare. Ye thread safety provide karta hai aur data inconsistency se bachata hai.

=>Jab ek method ko synchronized keyword ke saath declare kiya jata hai, to ek hi thread us method ko execute kar sakta hai, baaki threads ko wait karna padta hai.

=>Synchronization mainly shared resources (e.g., variables, files, databases) ke access ko control karne ke liye use hota hai.

 */
public class D_ThreadSynchronizationDemo {

    // Shared resource
    static class Counter {
        private int count = 0;
        
        // Synchronized method
        public synchronized void increment() {
            count++;
        }
        
        // Synchronized block
        public void decrement() {
            synchronized(this) {
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        // Create 100 threads that increment the counter
        Thread[] incrementThreads = new Thread[100];
        for (int i = 0; i < incrementThreads.length; i++) {
            incrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            incrementThreads[i].start();
        }
        
        // Create 50 threads that decrement the counter
        Thread[] decrementThreads = new Thread[50];
        for (int i = 0; i < decrementThreads.length; i++) {
            decrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.decrement();
                }
            });
            decrementThreads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread t : incrementThreads) {
            t.join();
        }
        for (Thread t : decrementThreads) {
            t.join();
        }
        
        System.out.println("Final count: " + counter.getCount()); // Should be 50000
    }
}