/*Given an inter array 'a' sorted in non-decreasing order, 
return an array of the squares of each number sorted in non decreasing order
*/


import java.util.*;
public class SquarInArray {
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
   static int[] squares_Sort(int[] arr)
    {
        int n=arr.length;
        int left=0,right=n-1;
        int[] ans=new int[n];
        int k=0;
        while(left<=right){
            if(Math.abs(arr[left])>Math.abs(arr[right])){
                ans[k++]=arr[left]*arr[left];
                left++;
            }
            else{
                ans[k++]=arr[right]*arr[right];
                right--;
            }   
        }
        return ans;

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
        int[] ans=squares_Sort(arr);
        revInplace(ans);
        PrintArray(ans);
        
    }   
        
}
