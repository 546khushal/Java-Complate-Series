/*Largest rectangle in Histogram
Given an array of integer heights representing the histogram's
bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram

 */

import java.util.*;
class Q7_LargestAreaHistogram{
    static int largestRectangleArea(int[] heights){
        int n= heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        //calculate nse[]
        st.push(n-1);//index
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?(n):(st.peek());
            st.push(i);
        }
        //empty stack
        while(st.size()>0){
            st.pop();
        }
        //caalculate pse[]
        st.push(0);
        pse[0]= -1;
        for(int i=1 ;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?(-1):(st.peek());
            st.push(i);
        }

        //maximum area of rectangle
        int max=-1;
        for(int i=0;i<n;i++){
            int area = heights[i]*(nse[i]-pse[i]-1);
            max=Math.max(max,area);
        }
        return max;

    }
    
    public static void main(String[] args){
        //int[] arr={2,1,5,6,2,3};//Max area of ractangle is: 10
        //int[] arr={5,2,4,6,3,5};//Max area of ractangle is: 12
        int[] arr={1,1};
        System.out.println("Max area of ractangle is: "+ largestRectangleArea(arr));

    }

}