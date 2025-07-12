import java.util.LinkedList;
import java.util.Queue;

class Q3_StackUsingQueue {
    private Queue<Integer> q = new LinkedList<>();
    
    // Push operation - O(1) time
    public void push(int x) {
        q.add(x);
    }
    //ydi pop me O(1) krna to push me rotate krne hue dale nya element aane pr phle vale piche
    // Pop operation - O(n) time
    public int pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Rotate the queue to bring last element to front
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }
    
    // Top operation - O(n) time
    public int top() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Rotate the queue to bring last element to front
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }
        int topElement = q.peek();
        // Restore the queue by putting the element back
        q.add(q.remove());
        return topElement;
    }
    
    // Check if stack is empty
    public boolean empty() {
        return q.isEmpty();
    }

    public void display() {
        System.out.print("Stack (top to bottom): ");
        
        if (empty()) {
            System.out.println("empty");
            return;
        }
        
        // Temporary queue to preserve elements
        Queue<Integer> temp = new LinkedList<>();
        
        // Display elements by rotating them out
        while (!q.isEmpty()) {
            int element = q.remove();
            System.out.print(element + " ");
            temp.add(element);
        }
        
        // Restore the original queue
        while (!temp.isEmpty()) {
            q.add(temp.remove());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q3_StackUsingQueue stack = new Q3_StackUsingQueue();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("After push operations");
        stack.display();
        
        System.out.println("Top element: " + stack.top()); // 4
        System.out.println("Popped: " + stack.pop());     // 4
        System.out.println("Popped: " + stack.pop());     // 3
        
        System.out.println("Top element: " + stack.top()); // 2
        System.out.println("Is empty: " + stack.empty());  // false
        
        stack.push(5);
        System.out.println("New top element: " + stack.top()); // 5
    }
}