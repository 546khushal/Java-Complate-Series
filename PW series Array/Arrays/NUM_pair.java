//Find the total number of pair int the array whose sum is equal to the given value x.
import java.util.*;
class calculation{
    public int pairSum(int[] arr,int target){
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans++;
                }
            }
        }
        return ans;
    } 

}

public class NUM_pair{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter "+n+" elemnts ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.printf("Enter target sum ");
        int target = sc.nextInt();

        calculation obj = new calculation();


        System.out.println(obj.pairSum(arr, target));
    }
}