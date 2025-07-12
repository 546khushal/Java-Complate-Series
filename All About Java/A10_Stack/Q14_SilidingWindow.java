/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/
import java.util.*;
class Q14_SilidingWindow{
    /*
    //(n - k + 1) * k ≈ O(nk) -> O(n × k) Space complexity O(n)
    //not a good aproach
    public static int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        int[] ans = new int[n-k+1];//n-(k-1)
        int p=0;
        for(int i=0;i<n-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max,nums[j]);
            }
            ans[p++]=max;
        }
        return ans;
    }*/

    
    
    /*
    //optimize code better than above code   for large data O(n*k)
    public static int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        int[] ans = new int[n-k+1];//n-(k-1)
        int p=0;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(n-1);
        nge[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[i]>nums[st.peek()]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        for(int i=0;i<n-k+1;i++){
            int j = i;
            int max=nums[j];
            while(j<i+k){
                max=nums[j];
                j=nge[j];
            }
            ans[p++]=max;
        }
        return ans;
    }
    */
   //leetcode problem solve in O(n)
    //optimize code better than above code   for large data O(n)
    public static int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        int[] ans = new int[n-k+1];//n-(k-1)
        int p=0;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(n-1);
        nge[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[i]>nums[st.peek()]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int j=0;
        for(int i=0;i<n-k+1;i++){
            //int j = i;
            if(j>=i+k)j=i;
            int max=nums[j];
            while(j<i+k){
                max=nums[j];
                j=nge[j];
            }
            ans[p++]=max;
        }
        return ans;
    }
    
    public static void main(String[] args){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res =  maxSlidingWindow(arr,k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}