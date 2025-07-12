import java.util.*;
class A6_PriorityQueue{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();//min priority queue
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//max priority queue
        
        pq.add(10);
        pq.add(5);
        pq.add(7);
        System.out.println(pq.peek());//5 - the smallest ele has the higest priority queue
        System.out.println(pq);//[5, 10, 7] - Guarantee -topmost ele will be the smallest
        System.out.println(pq.poll());//5
        System.out.println(pq);//[7, 10] - Guarantee -topmost ele will
    }
}