/**
 * THREAD STATES AND LIFECYCLE DEMONSTRATION
 * 
 * Thread states in Java:
 * 1. NEW - Created but not started
 * 2. RUNNABLE - Started and eligible to run
 * 3. BLOCKED - Waiting for a monitor lock
 * 4. WAITING - Waiting indefinitely for another thread
 * 5. TIMED_WAITING - Waiting for specified time
 * 6. TERMINATED - Completed execution
 */
public class B_ThreadStatesDemo {

    public static void main(String[] args) throws InterruptedException {
        // NEW state
        Thread thread = new Thread(() -> {
            try {
                // TIMED_WAITING state
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread running");
        });
        
        System.out.println("State after creation: " + thread.getState()); // NEW
        
        // RUNNABLE state
        thread.start();
        System.out.println("State after start: " + thread.getState()); // RUNNABLE
        
        // Main thread sleeps to let new thread reach TIMED_WAITING
        Thread.sleep(4000);//Thread running ->after 1sec kyuki thread me sleep 1sec ka 
        //after 4sec
        System.out.println("State during sleep: " + thread.getState()); // TIMED_WAITING
        
        // Wait for thread to complete
        thread.join();
        System.out.println("State after completion: " + thread.getState()); // TERMINATED
        
        // BLOCKED state demonstration
        Object lock = new Object();
        
        Thread t1 = new Thread(() -> {
            synchronized(lock) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            synchronized(lock) {
                System.out.println("Got the lock");
            }
        });
        
        t1.start();
        Thread.sleep(100); // Ensure t1 gets lock first
        t2.start();
        Thread.sleep(100); // Ensure t2 is started
        System.out.println("State when waiting for lock: " + t2.getState()); // BLOCKED
    }
}
/*

State after creation: NEW
State after start: RUNNABLE
Thread running
State during sleep: TERMINATED
State after completion: TERMINATED
State when waiting for lock: BLOCKED
Got the lock


Time    Action
------------------------------------------------
0ms     Main: Creates thread (NEW)
1ms     Main: Starts thread (RUNNABLE)
2ms     Main: Begins 4000ms sleep
        Thread: Begins 1000ms sleep (TIMED_WAITING)

1002ms  Thread: Wakes up, prints "Thread running", dies (TERMINATED)

4002ms  Main: Wakes up
        Checks thread state → TERMINATED
        Prints "State during sleep: TERMINATED"
        join() → immediate (already dead)
        Prints "State after completion: TERMINATED"

4012ms  Main: Creates t1/t2, starts t1
        t1: Takes lock, sleeps 4000ms (TIMED_WAITING)

4112ms  Main: Starts t2 (100ms later)
        t2: Tries to take lock → BLOCKED

4212ms  Main: Checks t2 state → BLOCKED
        Prints "State when waiting for lock: BLOCKED"

8012ms  t1: Wakes up, releases lock, dies
        t2: Gets lock, prints "Got the lock", dies
 */