import java.util.Scanner;
class Searching{
    static Scanner sc=new Scanner(System.in);
    //TC -> O(n)
    static  int Linear_search(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
    //TC O(log n)  SC=O(1)
    static int Binary_search(int[] arr,int target){
        int low=0,high=arr.length;//constant
        while(low<high){ //n/2^k =1 ->k=log2n  -> k=log n
            int mid=(low+high)/2;
            if(arr[mid]==target)
                return mid+1;
            else if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;  //constant
    }

    /*//run all cases in GeekforGeeks
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int left=0;
        int right=arr.length-1;
        int result = -1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==k){
                result=mid;
                right= mid-1;
            }else if(arr[mid]<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }*/
    /*t(n) = t(n/2)+c
        =t(n/4)+2c
        =t(n/8)+3c
        =t(n/2^k)+kc
            t(n/2^k)=1
            k=log n
    t(n)=t(1)+clogn
    TC    = O(logn)
    SC    = O(logn) 
    */
    static int Binary_search_Rec(int[] arr,int low,int high,int target){
        int mid;
        if(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==target)
                return mid+1;
            else if(arr[mid]<target)
                return Binary_search_Rec(arr,mid+1,high,target);
            else    
                return Binary_search_Rec(arr,low,mid-1,target);
        }
        return -1;
    }
    static void ReadArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
    }
    static void PrintArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println("Enter Size of array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        ReadArray(arr,size);
        PrintArray(arr,size);

        System.out.println("Enter Target: ");
        int target=sc.nextInt();
        
        //int res = Linear_search(arr,target);
        //int res = Binary_search(arr,target);
        int res = Binary_search_Rec(arr,0,size-1,target);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Element %d is found at index %d ",target,res);
        }
    }
}