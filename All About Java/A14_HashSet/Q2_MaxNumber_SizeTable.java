/*pw skill lecture 62 java
You are given a distinct pairs.Each pair is numbered from 1 to n.All These apirs are initially put in a bag.
you need to pair up each number. you take numbers one by one from the bag and for each number you looks whether the pair of this number has already been taken out the bag or not . 
if not (That means the pair of this number is still in the bag), you put the current number on the table in front of him. otherwisem=, you put both number from the pair asiz=de , Print the maximum number of number that were on the table at the same time.
Input:
1
11
output 1

Input 
3
2 1 1 3 2 3 
output 2
 */
import java.util.*;
class Q2_MaxNumber_SizeTable{
    
    static int MaxNumberOnTable(int[] bag){
        HashSet<Integer> table = new HashSet<>();
        int max = 0;
        for(int i=0;i<bag.length;i++){
            int num = bag[i];
            if(table.contains(num)){
                table.remove(num);
            }else{
                table.add(num);
                max =Math.max(max,table.size());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,1,3,2,3};
        System.out.println(MaxNumberOnTable(nums));
    }

}