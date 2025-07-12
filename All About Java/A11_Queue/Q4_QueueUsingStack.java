import java.util.*;
class Q4_QueueUsingStack{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();
    //push efficient code
    public void add(int x) {
        st.push(x);
    }
    public int remove(){
        while(st.size()>1){
            helper.push(st.pop()); 
        }
        int temp = st.pop();
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
        return temp;
    }
    public int peek(){
        while(st.size()>1){
            helper.push(st.pop()); 
        }
        int temp = st.peek();
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
        return temp;
    }
    public void display(){
        while(!st.isEmpty()){
            helper.push(st.pop());
        }
        while(!helper.isEmpty()){
            System.out.print(helper.peek()+" ");
            st.push(helper.pop());
        }
        System.out.println();
    }

    /*
    //pop Efficient
    public void push(int x){
        if(st.size()==0)st.push(x);
        else{
            while(st.size()>0){
                helper.push(st.pop());
            }
            st.push(x);
            while(!helper.isEmpty()){
                st.push(helper.pop());
            }
        }
    
    }
    public int remove(){
        return st.pop();
    }
    public int peek(){
        return st.peek();
    }
     */

    public static void main(String[] args){
        Q4_QueueUsingStack q = new Q4_QueueUsingStack();
    
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
         q.display();

        q.remove();
        q.remove();
         q.display();

         System.out.println("Top element: "+q.peek());

    }
}