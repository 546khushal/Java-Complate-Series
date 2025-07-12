/*Given an inter array of size n. Answeer qqueries where you
need to print the sum
of value in a given range of indices from 1 to r(both include).
NOTE:The values of 1 and r in queries follow 1-based indexing.

l=3
r=5
a=   2 4 1 3  6  5
pref=2 6 7 10 16 21
sum l to r=pref[r]-pref[l-1]
l=1,r=5   p[5]-p[0]=16-0=16
l=2,r=6   p[6]-p[1]=21-2=19
l=3,r=4   p[4]-p[2]=10-6=4
l=5,r=5   p[5]-p[4]=16-10=6 

*/

//(bootforce Approch)ydi yha hm loop l se start k r tk jaye result shi but time& space comlexity more
//sum+=a[i]
import java.util.*;
public class Queries_Sum1_r {
    //optimize
    static int[] P_Sum(int[] arr)
    {
        int n=arr.length;
        for(int i=1;i<n;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
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
        int[] arr = new int[n+1];// Array of size n+1 for 1-based indexing
        System.out.println("Enter " + n + " elements:");
        
        //Quetion me de rakha 1 base array to 1 se suru
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter number of Queries: ");
        int q=sc.nextInt();
        
        int[] prefixSum=P_Sum(arr);
        while(q>0){
            System.out.print("Enter l value: ");
            int l=sc.nextInt();
            System.out.print("Enter r value: ");
            int r=sc.nextInt();
            int ans= prefixSum[r] - prefixSum[l-1];
            System.out.println("Sum :"+ans);
            q--;
        
        }
        
    }   
        
}
