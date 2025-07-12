/*Given an array of size N containg only 0s,1s,and 2s; sort the array in ascending order. 
input N=6 arr[]={0 2 1 2 0 0 }
output {0 0 0 1 2 2}

1)sort algo->nlogn ->non linear
2)count sort->O(n),O(1) ->2pass use 
3)    1pass linear
*/
public class Sort0_1_2{
    
    static void PrintArray(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //2nd approach
    static void Sort(int[] num,int n){
        int count_0=0,count_1=0,count_2=0;
        for(int j: num){
            if(j==0){
                count_0++;
            }else if(j==1){
               count_1++;
            }else{
                count_2++;
            }
        }
        int k=0;
        while(count_0 > 0){
            num[k++]=0;
            count_0--;
        }
        while(count_1 > 0){
            num[k++]=1;
            count_1--;
        }
        while(count_2 > 0){
            num[k++]=2;
            count_2--;
        }
    }
    //3rd Approach Duch National flag Algo
    static void DNF(int[] arr,int n){
        
    }
    public static void main(String[] args){
        int[] arr={0,2,1,2,0,0};
        Sort(arr,arr.length);
        PrintArray(arr,arr.length);
    }
}

