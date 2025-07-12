/*Given an array arr[]  and a positive integer k, find 
the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.
Examples:
Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.
*/
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
class Q5_FirstNegative{
    /*static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int  n = arr.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }    
        for(int i=0;i<n-k+1;i++){
            if(!q.isEmpty() && q.peek()<i)
                q.remove();
            
            if(!q.isEmpty() && q.peek()<=i+k-1){
                    result.add(arr[q.peek()]);
            }
            else if(!q.isEmpty()){
                result.add(0);
            }
            else{
                result.add(0);
            }
        }
        return result;
        
    }*/
    
    //Optimize
    static List<Integer> firstNegInt(int arr[], int k) {
            int n = arr.length;
            List<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            
            // First collect all negative numbers' indices
            for(int i = 0; i < n; i++) {
                if(arr[i] < 0) {
                    q.add(i);
                }
            }    
            
            // Find first negative in each window
            for(int i = 0; i < n - k + 1; i++) {
                // Remove indices that are before current window
                while(!q.isEmpty() && q.peek() < i) {
                    q.remove();
                }
                
                // Check if we have a negative in current window
                if(!q.isEmpty() && q.peek() <= i + k - 1) {
                    result.add(arr[q.peek()]);
                } else {
                    result.add(0);
                }
            }
            
            return result;

    }

    public static void main(String[] args) {
        
        // Sample input 1
        int[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k1 = 3;
        System.out.println("Input 1: " + Arrays.toString(arr1) + ", k = " + k1);
        System.out.println("Output: " + firstNegInt(arr1, k1));
        
        // Sample input 2
        int[] arr2 = {-8, 2, 3, -6, 10};
        int k2 = 2;
        System.out.println("\nInput 2: " + Arrays.toString(arr2) + ", k = " + k2);
        System.out.println("Output: " + firstNegInt(arr2, k2));
        
        // Sample input 3 (all positive)
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println("\nInput 3: " + Arrays.toString(arr3) + ", k = " + k3);
        System.out.println("Output: " + firstNegInt(arr3, k3));
        
        // Sample input 4 (all negative)
        int[] arr4 = {-1, -2, -3, -4, -5};
        int k4 = 3;
        System.out.println("\nInput 4: " + Arrays.toString(arr4) + ", k = " + k4);
        System.out.println("Output: " + firstNegInt(arr4, k4));                               
    }
}