//Sort  an Array show odd to even number 

import java.util.*;
public class SortEven_Odd {
   static void swap(int[] arr,int i,int j)
    {   int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    static void sortEvenOdd(int[] arr){
        int n=arr.length;
        int left=0,right=n-1;
        while(left<right){
            if(arr[left]%2 == 1  && arr[right]%2 == 0){
                swap(arr,left,right);
                left++;
                right--;
            }
            if(arr[left]%2==0){//even
                left++;
            }
            if(arr[right]%2==1){//odd 
                right--;
            }
        }
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
        sortEvenOdd(arr);
        PrintArray(arr);
        
    }   
        
}
