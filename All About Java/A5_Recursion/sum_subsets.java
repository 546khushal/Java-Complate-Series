//Given an array of integers,print sum of all subsets in it
public class sum_subsets{
    static void subsetSum(int[] a,int n,int index,int sum){
        if(index>=n){
            System.out.print(sum+" ");
            return;
        }
        //curr index+ sum
        subsetSum(a,n,index+1,sum+a[index]);//include
        //curr ans
        subsetSum(a,n,index+1,sum);//exclude
    }
    public static void main(String[] args){
        int[] a={2,4,5};
        subsetSum(a,a.length,0,0);
    }
}