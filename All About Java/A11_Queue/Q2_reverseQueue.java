import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
class Q2_reverseQueue{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);    //[1, 2, 3, 4]    
        //tc O(n) sc O(n)
        Stack<Integer> st = new Stack<>();
        while(!queue.isEmpty()){
            st.push(queue.poll());
        }
        while(!st.isEmpty()){
            queue.add(st.pop());
        }
        System.out.println("Reverse: "+queue);//Reverse: [4, 3, 2, 1]
    
        //reverse  first k element of queue
        int k = 3;
        while(k>0){
            queue.add(queue.poll());
            k--;
        }    
        System.out.println("First 3 elements reversed: "+queue);//First 3 elements reversed:[1, 4, 3, 2]
    
    }
}