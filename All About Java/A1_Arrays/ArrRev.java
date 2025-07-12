//Reverse array 

import java.util.*;
//method 1
public class ArrRev {
    static int[] revArray(int[] arr){
        int n= arr.length;
        int[] ans= new int[n];
        int j=0;
        for(int i=n-1;i>=0;i--){
            ans[j++]=arr[i];
        }
    return ans;
    }
    //method 2 without creating new array
    static void swap(int[] arr,int i,int j)
    {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;

    }
    //yha org array me change hoga qki copy reference banti hai
    static void revInplace(int[] arr){
        int i=0,j=arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
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
        
        System.out.println(" \nReverse Array is :" );
        // int[] ans=revArray(arr);
        // for(int i=0;i<n;i++){
        //     System.out.print(ans[i]+" ");
        // }
        revInplace(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        }
}
