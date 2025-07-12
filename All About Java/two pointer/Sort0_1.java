//Sort  an Array consisting of only 0s and 1s

import java.util.*;
public class Sort0_1 {
    /*
    static void sortZeroOnes(int[] arr){
        int n=arr.length;
        int zeroes = 0;
        //count number of 0
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zeroes++;
            }
        }
        //0 to zeroes-1: 0,zeroes to n-1 : 1
        for(int i=0;i<n;i++){
            if(i<zeroes){
                arr[i]=0;
            }else{
                arr[i]=1;
            }
        }
    }
    */
    //method 2 best case
    static void swap(int[] arr,int i,int j)
    {   int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    static void sortZeroOnes(int[] arr){
        int n=arr.length;
        int left=0,right=n-1;
        while(left<right){
            if(arr[left] == 1 && arr[right] == 0){
                swap(arr,left,right);
                left++;
                right--;
            }
            if(arr[left]==0){
                left++;
            }
            if(arr[right]==1){
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
        sortZeroOnes(arr);
        PrintArray(arr);
        
    }   
        
}
