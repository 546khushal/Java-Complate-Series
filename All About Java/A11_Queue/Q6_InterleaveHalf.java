/*Interleave the first half of the queue with second half
Input:1 2 3 4 
Output:1 3 2 4

Input:{11,12,13,14,15,16,17,18,19,20};
Output: 11 16 12 17 13 18 14 19 15 20
*/
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
class Q6_InterleaveHalf{
    /*public static int[] interleaveHalf(int[] arr){
        int n = arr.length;
        int mid = n/2;
        int i=0,j=mid;
        int[] res = new int[n];
        int k=0;
        while(i<=mid && j<=n-1){
            res[k++] = arr[i];
            res[k++] = arr[j];
            i++;
            j++;            
        }
        return res;
    }*/
   //challenge : using stack and into queue
   public static void interleaveHalf(Queue<Integer> q){
        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even.");
            return;
        }
         int halfSize = q.size() / 2;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first half into the stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(q.poll());
        }
        // Step 2: Enqueue stack elements back to queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move the first half of the queue (which was second half earlier) to the back
        for (int i = 0; i < halfSize; i++) {
            q.add(q.poll());
        }

        // Step 4: Push first half (original second half) into stack again
        for (int i = 0; i < halfSize; i++) {
            stack.push(q.poll());
        }
        // Step 5: Interleave stack and queue elements
        while (!stack.isEmpty()) {
            q.add(stack.pop());  // from second half
            q.add(q.poll());     // from first half
        }
    }

    /*diffrent approach//1 2 3 4 5 6 7 8
        step 1: move firsthalf to stack  q->5 6 7 8 
        step 2: stack to queue all q-> 5 6 7 8   4 3 2 1(stack se ulte order me aaya top se) 
        step 3: move firsthalf(2nd original) to stack  q->4 3 2 1  stack-> top 8 7 6 5
        step 4: one bye one stack to queue and queue to queue q->8 4 7 3 6 2 5 1
        step 5: reverse queue using stack (q se sabhi stack me stack se sabhi queue me)1 5 2 6 3 7 4 8

    */
    public static void main(String[] args){
        // int[] arr = {11,12,13,14,15,16,17,18,19,20};
        // int[] res = interleaveHalf(arr);
        // for(int i=0;i<res.length;i++){
        //     System.out.print(res[i]+" ");
        // }


        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        interleaveHalf(q);
        System.out.println("Interleaved Queue:");
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        } 
    }
}