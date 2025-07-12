/**
 * MULTITHREADING IN JAVA
 * 
 * Definition:
 * Multithreading is the ability of a CPU to execute multiple threads concurrently,
 * where each thread runs a process.
 * 
 * Key Concepts:
 * 1. Thread: A lightweight sub-process, the smallest unit of processing
 * 2. Process: A program in execution (contains multiple threads)
 * 3. Concurrency: Executing multiple threads alternately
 * 4. Parallelism: Executing multiple threads simultaneously
 * 
 * Thread States:
 * 1. NEW: Thread created but not started
 * 2. RUNNABLE: Thread ready to run (in JVM but may be waiting for OS resources)
 * 3. BLOCKED: Thread waiting for a monitor lock
 * 4. WAITING: Thread waiting indefinitely for another thread
 * 5. TIMED_WAITING: Thread waiting for specified time
 * 6. TERMINATED: Thread has completed execution
 * 
 * Ways to create threads:
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 3. Using Executor framework (recommended)
 * 
 * Thread Priority:
 * - MIN_PRIORITY (1)
 * - NORM_PRIORITY (5)
 * - MAX_PRIORITY (10)
 * 
 * Synchronization:
 * Used to control access of multiple threads to shared resources
 */

/**
 * BASIC THREAD CREATION IN JAVA
 * 
 * There are two main ways to create threads in Java:
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 
 * Key Differences:
 * - Extending Thread: Simple but limits inheritance (Java doesn't support multiple inheritance)
 * - Implementing Runnable: More flexible, allows extending other classes
 */
public class BasicThreadCreation {

    // Approach 1: Extending Thread class
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread extending Thread class is running - " 
                + Thread.currentThread().getName());
        }
    }

    // Approach 2: Implementing Runnable interface
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread implementing Runnable is running - " 
                + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // Creating thread by extending Thread class
        MyThread thread1 = new MyThread();
        thread1.start();//Thread extending Thread class is running - Thread-0

        // Creating thread by implementing Runnable
        // Thread thread2 = new Thread(new MyRunnable());
        // thread2.start();
        //or
        MyRunnable r1 = new MyRunnable();
        Thread t1 = new Thread(r1);
        t1.start();//Thread implementing Runnable is running - Thread-1
         

        // Creating thread with lambda (Java 8+)
        Thread thread3 = new Thread(() -> {
            System.out.println("Lambda thread is running - " 
                + Thread.currentThread().getName());
        });
        thread3.start();//Lambda thread is running - Thread-2
    }
}