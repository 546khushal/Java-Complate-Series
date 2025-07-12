/*Given a series of N daily price quates for a stack, we need to calculate the span of the stock's price for all N dats.
the Span of the stock's price in one day is the maximum number of 
consecutive days (starting from that day and going bacward) for  which the stock price was 
less than or equal tp the price of the day
Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
*/
import java.util.*;
class Q6_StockSpan{
    public static int[] StackSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        span[0]=1;//First day always has span 1
        stack.push(0);// Push the first index onto the stack

        for(int i=1;i<n;i++){
            //Pop elements from the stack while the current price is greater than the price at stack's top
            while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]){
                stack.pop();
            }
            //if stack becomes empty then the current price is greater than all previous prices
            span[i]=stack.isEmpty()?(i+1):(i-stack.peek());
            stack.push(i);//Push this element index onto the stack
        }
        return span;


    }
    
    public static void main(String[] args){
        int[] arr={100, 80, 60, 70, 60, 75, 85};
        int[] spans = StackSpan(arr);
        for (int span : spans) {
            System.out.print(span + " ");
        }
        // Output: 1 1 1 2 1 4 6
    }
}