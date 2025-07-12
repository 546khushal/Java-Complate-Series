/*
Remove consecutive subsequences
Given a sequence of number . Remove all the consecutive subsequence of length grater than or queal to 2 that contains the same element
1 2 3 4 5
1 2 3 true
3 4 5 true
2 3 4 5 true
5 3 2 false

1 2 2 3 10 10 10 4 4 4 5 7 7 2 base on quetion same element grater 2
1 3 5 2 
 */
import java.util.*;
class Q4_removeConsecutiveSubsequences{
    public static int[] remove(int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0 || st.peek()!=arr[i])st.push(arr[i]);
            else if(arr[i]==st.peek()){
                if(i==arr.length-1 || arr[i]!=arr[i+1] )st.pop();
            }
        }
        int[] res = new int[st.size()];
        int m=res.length;
        for(int i=m-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int[] result = remove(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
