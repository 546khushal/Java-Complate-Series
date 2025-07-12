//insert at bottom /recursive
//insert any position
//delete bottom / recursive
//display/ display rev recurisve
//reverse stack recursive
import java.util.*;
class Q2_InsertBottom_index{
    public static void displayRevRec(Stack<Integer> st){
        if(st.size()==0)return;
        int top=st.pop();
        System.out.print(top+" ");
        displayRevRec(st);
        st.push(top);
    }
    public static void InsertBottomRec(Stack<Integer> st,int value){
        if(st.size()==0){
            st.push(value);
            System.out.print(value+" ");
            return;}
        int top=st.pop();
        InsertBottomRec(st,value);
        st.push(top);
        System.out.print(top+" ");

    }
    //without print here
    public static void pushAtBottm(Stack<Integer> st,int value){
        if(st.size()==0){
            st.push(value);
            return;}
        int top=st.pop();
        pushAtBottm(st,value);
        st.push(top);
    }

    public static void RemoveBottomRec(Stack<Integer> st){
        if(st.size()==1){
            int ele=st.pop();
            System.out.println("Poped: "+ele);
            return;
        }
        int top = st.pop();
        RemoveBottomRec(st);
        st.push(top);
        System.out.print(top+" ");
    }
    public static void reverseRec(Stack<Integer> st){
        if(st.size()==1)return;
        int top=st.pop();
        reverseRec(st);
        pushAtBottm(st,top);
    }

    
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.print("Old stack: "+stack);

        /*Stack<Integer> stack2 = new Stack<>();
        while(stack.size()>0){
            stack2.push(stack.pop());
        }

        stack.push(99);//insert at bottom
        while(stack2.size()>0){
            stack.push(stack2.pop());
        }
        System.out.print("\nafter insert bottom: "+stack);
        */
       
       /*Stack<Integer> tmp=new Stack<>();
        System.out.print("\nEnter position to insert in stack :");
        int pos=sc.nextInt();
        System.out.print("Enter value: ");
        int value=sc.nextInt();
        while(stack.size()>pos-1){
            tmp.push(stack.pop());
        }
        stack.push(value);
        while(tmp.size()>0){
            stack.push(tmp.pop());
        }
        */
        //System.out.print("After insert at pos "+ pos +" in stack: \n"+stack);
    
        //System.out.print("\nInsert bottom recusive: ");
        //InsertBottomRec(stack,8);


        //System.out.print("\nRecursivley Reverse display: ");
        //displayRevRec(stack);


        /*System.out.print("\nremove bottom recusive: ");
        RemoveBottomRec(stack);
        RemoveBottomRec(stack);
        */

        //revsre using recursive
        reverseRec(stack);
        System.out.println("\nReverse stack using recursion: "+stack);
    }
}