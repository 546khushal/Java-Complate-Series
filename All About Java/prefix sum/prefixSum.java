/*Given an inter array 'a' ,return the prefix sum/running sum
in the same array without creating a new array
for example a=    2 1 3  4  5
            pref= 2 3 6  10 15
pref[0]=a[0]                  ||  a[0]            
pref[1]=a[0]+a[1]             ||  pref[0]+a[1]
pref[2]=a[0]+a[1]+a[2]..      ||  pref[1]+a[2]
pref[3]=a[0]+a[1]+a[2]+a[3]   ||  pref[2]+a[3]

pref[i]=pref[i-1]+a[i]

*/


import java.util.*;
public class prefixSum {
    /*static int[] P_Sum(int[] arr)
    {
        int n=arr.length;
        int[] pref= new int[n];
        pref[0]=arr[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+arr[i];
        }
        return pref;
    }
    */
   //wihtout create new Array
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
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PrintArray(arr);
        System.out.println("New Array:");
        int[] ans=P_Sum(arr);
        PrintArray(ans);
        
    }   
        
}
