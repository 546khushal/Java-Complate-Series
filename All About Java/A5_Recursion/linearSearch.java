import java.util.Scanner;
public class linearSearch{
    //time complexity O(n),space O(n)
    static boolean L_Search(int arr[],int n,int target,int index){
        //base case
        if(index>=n)return false;
        //self work
        if(arr[index]==target)return true;
        //recursive work
        return L_Search(arr,n,target,index+1); 
        // if(L_Search(arr,n,target,index+1)){
        //     return ture;
        // } 
        // else{
        //     return false;
        // }
    }
    
    static int findIndex(int arr[],int n,int target,int index){
        //base case
        if(index>=n)return -1;
        //self work
        if(arr[index]==target)return index;
        //recursive work
        return findIndex(arr,n,target,index+1); 
        
    }


    //all index if number more times
    static void findAllIndex(int arr[],int n,int target,int index){
        //base case
        if(index>=n)return;
        //self work
        if(arr[index]==target){
            System.out.print(index+" ");
        } 
        //recursive work
        findAllIndex(arr,n,target,index+1); 
        
    }
    
    static int lastIndices(int[] arr,int tgt, int idx){
        if (idx<0) return -1;
        if (arr[idx] == tgt){
            return idx;
        }
        return lastIndices(arr, tgt, --idx);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr ={2,5,3,2,3,1,9,3};
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        System.out.println("\n");
        if(L_Search(arr,arr.length,target,0)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println("At index: "+findIndex(arr,arr.length,target,0));
        findAllIndex(arr,arr.length,target,0);
    }
}