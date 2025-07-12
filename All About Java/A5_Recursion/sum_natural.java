//sum_natural number till n but with alternate signs
//1-2+3-4+5 = 3
import java.util.Scanner;
public class sum_natural{
    //simple seroes sum
    // static int Sum_series(int n){
    //     if(n==0)return 0;
    //     return Sum_series(n-1)+n;
    // }
    
    // series sum alternative sign
    static int Sum_series(int n){
        if(n==0)return 0;
        if(n%2==0){
        return Sum_series(n-1)-n;
        }
        return Sum_series(n-1)+n;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println(Sum_series(n));
        
    }
}