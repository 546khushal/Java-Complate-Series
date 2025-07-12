/*
Problem on binary search
find the first occurrence of a given element x, given that the given array is sorted, if no occurrence of x is found then return -1 
input = [2,5,5,5,6,6,8,9,9,9]
x=5
output 1
*/
import java.util.Scanner;
class Occurrence{
    static Scanner sc=new Scanner(System.in);
    
    static int First_occurrence(int[] arr,int target){
        int low=0,high=arr.length-1;
        int first_Occur = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                first_Occur=mid;
                high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        } 
        return first_Occur; 
        //yha element nhi mila to firstOccur -1 hi rhenga
    }

    static int Last_occurrence(int[] arr,int target){
        int low=0,high=arr.length-1;
        int last_Occur = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                last_Occur=mid;
                low=mid+1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        } 
        return last_Occur; 
        //yha element nhi mila to lastOccur -1 hi rhenga
    }
    
    static void PrintArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr={1,5,5,5,6,6,8,9,9,9};
        PrintArray(arr,arr.length);

        System.out.println("Enter Target: ");
        int target=sc.nextInt();
        
        //int res = First_occurrence(arr,target);
        int res = Last_occurrence(arr,target);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Element %d is found at index %d ",target,res);
        }
    }
}