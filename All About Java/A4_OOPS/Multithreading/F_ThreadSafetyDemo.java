import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * THREAD SAFETY AND CONCURRENT COLLECTIONS
 * 
 * Thread-safe approaches:
 * 1. Synchronization
 * 2. Atomic variables
 * 3. Immutable objects
 * 4. Thread-safe collections
 */
public class F_ThreadSafetyDemo {

    public static void main(String[] args) throws InterruptedException {
        // Atomic variables example
        AtomicInteger atomicCounter = new AtomicInteger(0);
        
        Thread[] atomicThreads = new Thread[10];
        for (int i = 0; i < atomicThreads.length; i++) {
            atomicThreads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicCounter.incrementAndGet();
                }
            });
            atomicThreads[i].start();
        }
        
        for (Thread t : atomicThreads) {
            t.join();
        }
        
        System.out.println("Atomic counter final value: " + atomicCounter.get());
        
        // Concurrent collections example
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<>();
        
        Thread writer1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                concurrentMap.put("Key" + i, i);
                threadSafeList.add("Item" + i);
            }
        });
        
        Thread writer2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                concurrentMap.put("Key" + i, i);
                threadSafeList.add("Item" + i);
            }
        });
        
        writer1.start();
        writer2.start();
        writer1.join();
        writer2.join();
        
        System.out.println("ConcurrentMap size: " + concurrentMap.size());
        System.out.println("ThreadSafeList size: " + threadSafeList.size());
    }
}