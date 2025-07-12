//Critical Point max and min distance 
//an-1<an>an+1->local maxima
//an-1>an<an+1->local minima

import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Q17D_distanceMaxMin{
    Node head;
    Node tail;
    void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    void display(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    void distanceMaxMin(){
        if (head == null || head.next == null || head.next.next == null) {
            System.out.println("Not enough nodes");
            return;
        }
        Node c1 = null; // First critical point
        Node c2 = null; // Second critical point
        int minDist = Integer.MAX_VALUE;
        int maxDist = 0;

        Node curr = head.next;
        int pos = 1;


        while (curr.next != null) {
            // Check if current node is critical point
            boolean isMax = curr.data > curr.prev.data && curr.data > curr.next.data;
            boolean isMin = curr.data < curr.prev.data && curr.data < curr.next.data;
            
            if (isMax || isMin) {
                if (c1 == null) {
                    c1 = curr; // First critical point found
                } else {
                    c2 = curr; // Next critical point found
                    
                    // Calculate distance between c1 and c2
                    int dist = 0;
                    Node temp = c1;
                    while (temp != c2) {
                        dist++;
                        temp = temp.next;
                    }
                    
                    // Update min and max distances
                    minDist = Math.min(minDist, dist);
                    maxDist = Math.max(maxDist, dist);
                    
                    // Move c1 to c2 for next comparison
                    c1 = c2;
                }
            }
            curr = curr.next;
            pos++;
        }
        
        if (c1 == null || c2 == null) {
            System.out.println("Not enough critical points");
        } else {
            System.out.println("Min distance: " + minDist);
            System.out.println("Max distance: " + maxDist);
        }
    }


    public static void main(String[] args){
        Q17D_distanceMaxMin list= new Q17D_distanceMaxMin();
        list.insert(1);
        list.insert(2);
        list.insert(5);
        list.insert(3);
        list.insert(2);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(1);
        list.insert(10);

        list.display();
        list.distanceMaxMin();
    }
}