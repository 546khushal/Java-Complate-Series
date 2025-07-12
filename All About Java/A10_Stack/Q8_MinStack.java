import java.util.Stack;

class Q8_MinStack {
    /*Stack<Integer>st = new Stack<>();
    Stack<Integer>min = new Stack<>();
    
    public void push(int val) {
        if(st.size()==0){
            st.push(val);
            min.push(val);
        }else{
            st.push(val);
        if(min.peek()<val){
            min.push(min.peek());
        }else{
            min.push(val);
        }
        }
    }
    public void pop() {
        st.pop();
        min.pop();
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return min.peek();
    }*/

   //without extra space
   Stack<Integer>st = new Stack<>();
   int min=Integer.MAX_VALUE;
   public void push(int val) {
        if(st.size()==0){
            st.push(val);
            min=val;
        }
        else if(val<min){
            st.push(2*val-min);
            min=val;
        }
        else st.push(val);
   }

   public void pop() {
        if(st.size()==0)return;
         int popped = st.pop();
        if (popped < min) {
            min = 2*min - popped;
        }
    }

    public int top() {
        if(st.size()==0){
            System.out.println("Underflow");
            return -1;
        }
        int top = st.peek();
        return (top < 0) ? min : top;
            
    }
    public int getMin() {
        if(st.size()==0)return -1;
        return min;
    }

    public static void main(String[] args) {
        Q8_MinStack minStack = new Q8_MinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(4);
        minStack.push(1);
        minStack.push(3);

        System.out.println("Top: " + minStack.top());       // Output: 3
        System.out.println("Min: " + minStack.getMin());     // Output: 1

        minStack.pop();  // Remove 3
        minStack.pop();  // Remove 1 (minimum changes)

        System.out.println("Top: " + minStack.top());       // Output: 4
        System.out.println("Min: " + minStack.getMin());     // Output: 2
    }
}