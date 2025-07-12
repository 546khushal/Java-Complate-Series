/*A queue is a linear data structure that operates on the FIFO (First In, First Out) principle. This means the element added first to the queue is the one that is removed first. 

Java provides a Queue interface, commonly implemented using LinkedList.
*/
import java.util.*;
public class A6_Queue{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        //Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after enqueue: " + queue);//Queue after enqueue: [10, 20, 30]

        //Peek Operations
        System.out.println("Front element: "+queue.peek());//Front element: 10

        //Dequeue operation                         poll() ,remove()
        System.out.println("Removed element: "+queue.poll());//Removed element: 10
        System.out.println("Queue after dequeue: " + queue);//Queue after dequeue: [20, 30]

        //Check if queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());//Is the queue empty? false
    }
}

/*
Common Uses of Queue:
    Scheduling tasks (e.g., CPU scheduling).
    Handling requests (e.g., network packet processing).
    Implementing BFS (Breadth-First Search) in graphs or trees.

 */