/*
Given an unsorted array of integer nums,return the length of the longest consecutive element sequence.
input n=6
nums = [100,4,200,1,3,2]
output 4

n=10
nums={0,3,7,2,5,8,4,6,0,1}
output 9
 */
import java.util.*;
class Q1_LongestConsecutiveElement{
    public static int LongestConsecutiveElement(int[] nums){
        HashSet<Integer> st = new HashSet<>();
        for(int num:nums)st.add(num);
        
        int maxStreak=0;
        for(int num:st){
            if(!st.contains(num-1)){
                int currNum = num;
                int currStreak =1;
                while(st.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak,currStreak);
            }
        }
        return  maxStreak;
    }
    public static void main(String[] args) {
        int[] arr={0,3,7,2,5,8,4,6,0,1};
        System.out.println(LongestConsecutiveElement(arr));
    }
}