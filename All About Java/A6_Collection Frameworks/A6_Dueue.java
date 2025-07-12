//Deque in java Collection
import java.util.Deque;
import java.util.LinkedList;
class A6_Dueue{
    public static void main(String[] args){
        Deque<Integer> dq = new LinkedList<>();
    
        //add
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        System.out.println(dq);//[3, 2, 1]
        //dq.add;//last me
        
        dq.addLast(11);
        dq.addLast(22);
        dq.addLast(33);
        System.out.println(dq);//[3, 2, 1, 11, 22, 33]

        dq.removeFirst();
        dq.removeFirst();
        System.out.println(dq);//[1, 11, 22, 33]
        //dq.remove();//first se
        dq.removeLast();
        dq.removeLast();
        System.out.println(dq);//[1, 11]

        System.out.println(dq.getFirst());//1
        System.out.println(dq.getLast());//11

        dq.removeAll(dq);
        System.out.println(dq);//[]

        //dq.removeFirstOccurrence(2);//phle jha 2 hoga vo atega
        dq.removeLastOccurrence(2);//last jha 2 hoga vo atega

    }
}