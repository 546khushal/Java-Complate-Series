//Copy contents of one stack to another in same order
import java.util.*;
class Q1_copyStack{
   public static void main(String[] args){
    Stack<Integer> stack = new Stack<>();
    Scanner sc = new Scanner(System.in);
    int n;
    System.out.print("Enter n to insert: ");
    n=sc.nextInt();
    for(int i=0;i<n;i++){
        System.out.print("Enter Element: ");
        int value=sc.nextInt();
        stack.push(value);
    }
    System.out.println("Original Stack : "+stack);

    Stack<Integer> stack2 = new Stack<>();
    //reverse ho gya 
    while(stack.size()>0){
        stack2.push(stack.pop());
    }
    Stack<Integer> stack3 = new Stack<>();
    //reverse ho gya phle jaisa bna ab 
    while(stack2.size()>0){
        stack3.push(stack2.pop());
    }
    
    System.out.println("Copy Stack : "+stack3);

    //reverse order me same stack me dalna to stack->stack2(rev)->stack3(rev (org mil gya ))->push again org stack 
   
   } 
}