import java.util.Scanner;
import java.util.ArrayList;

public class indexArray{
   
    static ArrayList<Integer> findAllIndex(int arr[],int n,int target,int index){
        /* arr->4 4 3 4
        target-> 4
        ans(arraylist)->{0,1,3}
         */
        //base case
        if(index>=n){
            return new ArrayList<>();//return empty arraylist
        }
        //self work
        ArrayList<Integer> ans=new ArrayList<>();
        if(arr[index]==target){//ans->{0}
            ans.add(index);
        }
        //recursive work
        ArrayList<Integer> smallans    = findAllIndex(arr,n,target,index+1); //smallans->{1,3}
        ans.addAll(smallans);//->{0,1,3}
        return ans;
    }
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int[] arr ={1,2,4,4,5,4};
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        
        ArrayList<Integer> ans = findAllIndex(arr,arr.length,target,0);
        for(Integer i:ans){
            System.out.print(i+" ");
        }
    }
}