/*
Given an array of length n and a target, return a pair whose sum is equal to the target .
if there is no such pair, return -1.
imput:
n=4
arr = [1,5,7,-1]
target = 6
output: 0 1
 */
import java.util.*;
class Q3_TwoSum{
    //O(n^2)
    /*public static int[] twoSum(int[] arr,int n,int target){
        int[] ans = {-1};
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]==target-arr[i]){
                    ans = new int[]{i,j};
                    return ans;
                }
            }
        }
    return ans;
    }*/

   //Time complexity O(n)
    public static int[] twoSum(int[] arr,int n,int target){
       HashMap<Integer,Integer> mp = new HashMap<>();
       for(int i=0;i<n;i++){//partner find krte hai jaise a[i] 10 or target 13 to hm 3 ko find krte hai
            int complement = target - arr[i];
            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement),i};
            }
            mp.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1,5,7,-1};
        int target = 6;
        int[] result = twoSum(arr, n, target);
        if(result[0] != -1 && result[1] != -1){
            System.out.println("("+result[0]+","+result[1]+")");
            }
        else{
            System.out.println("-1");
            }
        }
}