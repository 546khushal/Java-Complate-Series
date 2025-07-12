/*
Next greater element
1 3 2 1 8 6 3 4
aisa konsa element jiske aage ke array me usse bada
1 ka 3 
3 ka 8
2 ka 8
1 ka 8
8 ka -1
6 ka -1
3 ka 4
4 ka -1
*/
import java.util.*;
class Q5_nextGreaterElement{
    //TC O(n),SC O(n)
    public static int[] Next_greater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && st.peek()<=arr[i] ){
                st.pop();
            }
            if(st.size()==0)res[i]=-1;
            else
                res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    
    public static void main(String[] args){
        int[] arr={1,3,2,1,8,6,3,4};
        /*
        //normal way with array O(n^2)
        int[] res= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=-1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                   res[i]=arr[j];
                   break; 
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

        */
       int[] res=Next_greater(arr);
       for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
}