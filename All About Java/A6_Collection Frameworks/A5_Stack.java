/*Stack is a subclass of Vector that implements a standard last-in, first-out stack. 

 */
import java.util.*;
public class A5_Stack{
    static void showpush(Stack st,int a){
        st.push(new Integer(a));
        System.out.println("push(" + a + ")"); 
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st) { 
        System.out.print("pop -> "); 
        Integer a = (Integer) st.pop(); 
        System.out.println(a); 
        System.out.println("stack: " + st); 
    } 

    public static void main(String args[]) { 
        Stack st = new Stack(); 
        System.out.println("stack: " + st); //stack: []
        showpush(st, 42); //push(42) stack: [42]
        showpush(st, 66); //push(66) stack: [42, 66]
        showpush(st, 99); //push(99) stack: [42, 66, 99]
        showpop(st); //pop -> 99 stack: [42, 66]
        showpop(st); //pop -> 66 stack: [42]
        showpop(st); //pop -> 42 stack: []
        try { 
            showpop(st); 
        } catch (EmptyStackException e) { 
            System.out.println("empty stack"); //pop -> empty stack
        }
    }   

}
/*
import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after push: " + stack);

        // Peek operation
        System.out.println("Top element: " + stack.peek());

        // Pop operation
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
 */