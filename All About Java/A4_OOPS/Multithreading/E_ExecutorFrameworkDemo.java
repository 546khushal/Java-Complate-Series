import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * EXECUTOR FRAMEWORK
 * 
 * The Executor framework provides a higher-level replacement for working with threads directly
 * 
 * Benefits:
 * - Thread pooling
 * - Better resource management
 * - Easier task submission
 * - Built-in scheduling
 */
public class E_ExecutorFrameworkDemo {

    public static void main(String[] args) {
        // Fixed thread pool
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        // Submit Runnable tasks
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("Executing task " + taskId + " in " 
                    + Thread.currentThread().getName());
            });
        }
        
        // Submit Callable tasks (can return values)
        Future<Integer> future = fixedPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 42;
            }
        });
        
        // Shutdown the pool (no new tasks accepted)
        fixedPool.shutdown();
        
        try {
            // Wait for tasks to complete
            if (!fixedPool.awaitTermination(60, TimeUnit.SECONDS)) {
                fixedPool.shutdownNow();
            }
            
            // Get result from Callable
            if (future.isDone()) {
                System.out.println("Callable result: " + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Cached thread pool (creates threads as needed)
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        // Scheduled thread pool
        ExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // Single thread executor (tasks execute sequentially)
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    }
}