/*
Given an array arr[] of length N find the length of the largest subarray with sum equal to 0
input:
n=8
arr] = {15,-2,2,-8,1,7,10,23};
output 5
 */

/*
arr         15 -2 2 -8 1 7 10
pref sum    15 13 15
fir se 15 hua yani 0 ho rha -2 ,2 
phle jha 15 dikha vha se ab jha dikha 
maxLen =2-0 = 2
pref sum    15 13 15 7 8 15 
maxLen = 5-0 = 5
pref sum    15 13 15 7 8 15 25
return maxLen

 */
import java.util.*;
class Q4_LargestSubarrayWith0Sum{
    public static int maxLen(int[] arr, int n) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int maxLen = 0;
        int prefSum = 0;
        mp.put(0,-1);
        for(int i=0;i<arr.length;i++){
            prefSum+=arr[i];
            if(mp.containsKey(prefSum)){
                maxLen = Math.max(maxLen,i-mp.get(prefSum));
            }else{
                mp.put(prefSum,i);
            }
        }
        return maxLen;
              
  }
    public static void main(String[] args){
        int[] arr = {15, -2, 2, -8, 1,7, 10, 23};
        int n = arr.length;
        System.out.println("Length of the largest subarray with 0 sum is " + maxLen(arr,n));
        
    }
}