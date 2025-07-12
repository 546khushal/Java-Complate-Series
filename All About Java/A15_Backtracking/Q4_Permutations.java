/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]] */
import java.util.*;
class Q4_Permutations{
    
    // Approach 1: Recursive with extra space
    public static List<List<Integer>> permuteRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutations(nums, new ArrayList<>(), result, used);
        return result;
    }
    
    private static void generatePermutations(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                generatePermutations(nums, current, result, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    
    // Approach 2: Backtracking (Swapping elements)
    public static List<List<Integer>> permuteBacktrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if(start == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for(int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i); // Backtrack
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        
        System.out.println("Recursive Approach:");
        List<List<Integer>> recursiveResult = permuteRecursive(nums);
        System.out.println(recursiveResult);
        
        System.out.println("\nBacktracking Approach:");
        List<List<Integer>> backtrackResult = permuteBacktrack(nums);
        System.out.println(backtrackResult);
        

    }
}