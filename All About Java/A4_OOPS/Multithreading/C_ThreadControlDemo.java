/**
 * THREAD PRIORITY AND CONTROL METHODS
 * 
 * Thread priorities range from 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY)
 * Default priority is 5 (NORM_PRIORITY)
 * 
 * Important methods:
 * - setPriority(), getPriority()
 * - sleep()
 * - join()
 * - yield()
 * - interrupt()
 */
public class C_ThreadControlDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread priority demonstration
        Thread highPriorityThread = new Thread(() -> {
            System.out.println("High priority thread running");
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        
        Thread lowPriorityThread = new Thread(() -> {
            System.out.println("Low priority thread running");
        });
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        
        highPriorityThread.start();
        lowPriorityThread.start();
        
        // sleep() demonstration
        System.out.println("Main thread sleeping for 1 second");
        Thread.sleep(1000);
        System.out.println("Main thread woke up");
        
        // join() demonstration
        Thread workerThread = new Thread(() -> {
            try {
                System.out.println("Worker thread starting work");
                Thread.sleep(2000);
                System.out.println("Worker thread completed work");
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted");
            }
        });
        
        workerThread.start();
        System.out.println("Main thread waiting for worker to complete");
        workerThread.join(1000); // Wait for 1 second max
        System.out.println("Main thread continuing execution");
        
        // yield() demonstration
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Yielding thread iteration " + i);
                Thread.yield(); // Hint to scheduler to give other threads a chance
            }
        }).start();
        
        // interrupt() demonstration
        Thread interruptibleThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });
        
        interruptibleThread.start();
        Thread.sleep(1000);
        interruptibleThread.interrupt();//Thread was interrupted!
    }
}