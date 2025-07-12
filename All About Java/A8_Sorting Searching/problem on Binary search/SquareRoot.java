/*
Problem on binary search
Find the square root of the given non negative value x.
Round it off ot the nearest floor integer value
input x=2
output 2
input x=11
output 3
 */
import java.util.Scanner;
public class SquareRoot{
    //Linear solution Time Complexity: O(√x)
    /*y=0 → 0*0 <= 4 → y=1
    y=1 → 1*1 <= 4 → y=2
    y=2 → 2*2 <= 4 → y=3
    y=3 → 3*3 > 4 → loop break
    Return y-1 = 2 */
    
    static int fun(int x){
        int y=0;
        while(y*y<=x){
            y++;
        }
        return y-1;
    }

    //using Binary Search 
    /*
    Iteration 1: low=0, high=10 → mid=5 → 25>10 → high=4
    Iteration 2: low=0, high=4 → mid=2 → 4<10 → ans=2, low=3
    Iteration 3: low=3, high=4 → mid=3 → 9<10 → ans=3, low=4
    Iteration 4: low=4, high=4 → mid=4 → 16>10 → high=3
    Loop ends (low > high)
    Return ans=3  (3*3=9 ≤ 10)
     */
    //Time Complexity: O(log x)
    static int Binary_fun(int x){
        int low=0,high=x;
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int val=mid*mid;
            if(val==x){
                return mid;
            }
            else if(val<x){
                low=mid+1;
                ans=mid;
            }
            else{
                high=mid-1;
            }

        }
        return ans;
    }
    /*
    Integer part = 3 (3²=9 ≤ 10)
    Decimal calculation:
    Step 1: increment=0.1 → ans=3.1 (9.61≤10) → ans=3.2 (10.24>10) → ans=3.1
    Step 2: increment=0.01 → ans=3.11 (9.6721≤10) → ... → ans=3.16 (9.9856≤10) → ans=3.17 (10.0489>10) → ans=3.16
    Step 3: increment=0.001 → ans=3.161 (9.991921≤10) → ans=3.162 (9.998244≤10) → ans=3.163 (10.004569>10) → ans=3.162
    Final answer: 3.162  */
    public static float findSqrtWithPricision(int num, int precision) {
        int st = 0, end = num;
        double ans = -1.0;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            double val = mid * mid;
            if (val == num) {
                return mid;
            } else if (val < num) {
                st = mid + 1;
                ans = mid;
            } else {
                end = end - 1;
            }
        }
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= num) {
                ans += increment;
            }
            ans = ans - increment;// Ek step piche jao (kyuki last step ne limit cross kar di)
            increment = increment / 10;//(0.1 → 0.01 → 0.001...
        }
        return (float) ans;
  }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Target: ");
        int target=sc.nextInt();
        
        // int res = fun(target);
        int res = Binary_fun(target);
        System.out.println("Output is: "+res);

        double res2 = findSqrtWithPricision(10,3);
        System.out.println("with Pricision Output is: "+res2);

    }
}
