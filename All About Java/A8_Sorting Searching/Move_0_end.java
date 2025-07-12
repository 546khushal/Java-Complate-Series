/*givem an integer array arr,move all 0's to 
the end of it while mainting the relative order of the non zero element */

public class Move_0_end{
    
    //use bubble sort
    static void Move_zero(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]==0 && arr[j+1]!=0){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] arr={34,0,5,2,0,1,0,22};
        Move_zero(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}