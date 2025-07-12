import java.util.Queue;
import java.util.LinkedList;

class Q1_PrintAll{
    static void display(Queue<Integer> queue){
        Queue<Integer> q2 = new LinkedList<>();
        while(!queue.isEmpty()){
            int e = queue.remove();
            System.out.print(e+" ");
            q2.add(e);
        }
        while(!q2.isEmpty()){
            queue.add(q2.poll());
        }

    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        display(queue);
    }
}