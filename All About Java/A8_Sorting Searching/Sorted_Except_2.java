/*Given an array where all its element are sorted in increasing 
order except two swapped elements , 
sorts it in linear time. Assume there are no duplicates in the array 
Input A[]=[3,8,6,7,5,9,10]
        swap only 8,5 then sort
Output A[]=[3,5,6,7,8,9,10]
*/
public class Sorted_Except_2{
    static void Sort(int[] arr,int n){
        int x=-1;
        int y=-1;
        if(n<=1){//handling corner case
            return;
        }
        //process all adjacent elements
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){//1st conflict
                if(x==-1){
                    x=i-1;
                    y=i;
                }else{//2nd conflict
                    y=i;
                }
            }
        }
        int tmp=arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }
    static void PrintArray(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr={3,8,6,7,5,9,10};
        Sort(arr,arr.length);
        PrintArray(arr,arr.length);
                
    }
}