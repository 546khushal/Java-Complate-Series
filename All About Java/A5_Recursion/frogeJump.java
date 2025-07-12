/*there are N stones, numbered 0,1,2...N-1. for each i(0<=i<N),
the height of Stone i is hi. There is a frog who is initially on Stone 0. He repeat the 
following action some number of times to reach Stone N-1 
 
If the frog is currenlty on Stone i,jump to Stone i+1 or Stone i+2.
here, a cost of |hi-hj| is incurred, where j is the stone to land on.

find the minimum possible total cost incurred before the frog reaches Stone N.
input n=4
arr[]=10 30 40 20
Output= 30

*/
public class frogeJump{
    static int best(int[] h,int n,int idx){
        if(idx==n-1)return 0;
        int op1= best(h,n,idx+1)+Math.abs(h[idx+1]-h[idx]);
        if(idx==n-2)return op1;
        int op2 = best(h,n,idx+2)+Math.abs(h[idx+2]-h[idx]);
        
        return Math.min(op1,op2);
    }
    public static void main(String[] args){
        int[] h={10,30,40,20};
        System.out.println(best(h,h.length,0));
    }
}