/*
check if we can paertition the array into subarray with equal sum.
more formally check that the prefix sum of a 
part of the array is equal to the suffx sum if rest of the array
a=    5  3  2  6  3  1 
pref= 5  8  10 16 19 20
     ----10----
suff= 20 15 12 10  4 1
               ---10---
pref[i]==suff[i+1] than return true ,false

--->using only prefix
suffixSum=totalSum-prefixSum
suffixSum==prefixSum
example:
psum=5+3=8
suffixSum=20-8=12
psum=8+3=10
SumffixSum=20-10=10

*/


import java.util.*;
public class partition {
    static int findArraySum(int[] arr){
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        return totalSum;
    }
    static boolean equalSumPartition(int[] arr)
    {   int totalSum=findArraySum(arr);
        int prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            int suffixSum=totalSum-prefixSum;
            // Iteration 1: prefixSum = 5, suffixSum = 15 (Not equal)
            // Iteration 2: prefixSum = 8, suffixSum = 12 (Not equal)
            // Iteration 3: prefixSum = 10, suffixSum = 10 (Equal, return true)
            if(suffixSum==prefixSum){
                return true;
            }
        }
        return false;
    }
    


    static void PrintArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Equal partition posible: " + equalSumPartition(arr));
        
        
    }   
        
}
