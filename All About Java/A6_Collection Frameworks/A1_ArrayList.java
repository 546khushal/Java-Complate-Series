/*Java ArrayList class uses a dynamic array for storing the elements. It inherits AbstractList class 
and implements List interface

The important points about Java ArrayList class are: 
 
        Java ArrayList class can contain duplicate elements. 
        Java ArrayList class maintains insertion order. 
        Java ArrayList class is non synchronized. 
        Java ArrayList allows random access because array works at the index basis. 
        In Java ArrayList class, manipulation is slow because a lot of shifting needs to be occurred 
            if any element is removed from the array list.
declaration for java.util.ArrayList class. 
 */
import java.util.*;
class A1_ArrayList{
    public static void main(String[] args){
       //wrapper classes
        // Integer i = Integer.valueOf(4);
        // System.out.println(i);

        // Float f = Float.valueOf(4.09f);
        // System.out.println(f);
        
        ArrayList<Integer> l1 = new ArrayList<>();
        // ArrayList<boolean> l2 = new ArrayList<>();
        // ArrayList<Float> l3 = new ArrayList<>();
        
       //add new element at end
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        //add at index
        l1.add(1,9); // (index,element)

        //modifying element at index i
        l1.set(1,10);

        //remove an element at index i
        l1.remove(1);
        //remove element to value
        l1.remove(Integer.valueOf(8));

        //checking if element exists
        boolean ans = l1.contains(Integer.valueOf(6));
        System.out.println(ans);

        //if you don't specify class you can put anything inside l
        ArrayList l =new ArrayList();   //not given specific object
        l.add("khushal");
        l.add(22);
        l.add(69.7f);
        System.out.println(l);
        //reverse using collection 
        Collections.reverse(l);
        System.out.println(l);


        //sort 
        Collections.sort(l1);
        System.out.println(l1);
        Collections.sort(l1,Collections.reverseOrder());
        System.out.println(l1);

        //get an element at index i
        System.out.println(l1.get(1));//6
        for(int i=0;i<l1.size();i++){
            System.out.print(l1.get(i)+" ");
            
        }
        // System.out.println(l1);


        ArrayList<String> s1 = new ArrayList<>();
        s1.add("khushal");
        s1.add("Suthar");
        s1.add("kumar");
        System.out.println(s1);
        Collections.sort(s1);
        
        System.out.println(s1);        

 
    }
}

