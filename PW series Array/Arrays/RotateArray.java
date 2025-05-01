//Roatet Array k time

import java.util.*;
//method 1
public class RotateArray {
    //Use extra space int[] ans = new int[];
    static int[] rotateArray(int[] arr,int k){
        int n=arr.length;
        k=k%n;

        int[] ans=new int[n];
        int j=0;
        for(int i=n-k; i<n; i++){
            ans[j++]=arr[i];
        }
        for(int i=0;i<n-k;i++){
            ans[j++]=arr[i];
        }
        return ans;
    }

    //create without extra space
    static void swap(int[] arr,int i,int j)
    {   int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    static void rotateArray2(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        //piche se k value aage bhejega
        // reverse(arr,0,n-k-1);
        // reverse(arr,n-k,n-1);
        // reverse(arr,0,n-1);
        
        /////aage se k value piche bhejega
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
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
        System.out.println("Enter k to Rotatem: ");
        int k=sc.nextInt();
        // int[] ans= rotateArray(arr,k);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(ans[i]+" ");
        // }


        rotateArray2(arr,k);
        for (int i = 0; i < n; i++) {
             System.out.print(arr[i]+" ");
        }
    }   
        
}
