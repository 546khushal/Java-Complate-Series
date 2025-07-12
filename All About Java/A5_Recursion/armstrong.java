
import java.util.Scanner;
public class armstrong{
    static int count_digit(int n){
        if(n>=0 && n<=9)return 1;
        return count_digit(n/10)+1;
    }   
    static int pow(int p,int q){
        if(q==0)return 1;
        int smallpow= pow(p,q/2);
        if(q%2==0){
            return smallpow*smallpow;
        }else{
            return smallpow*smallpow*p;
        }
    }
    static int armstrong_number(int n,int d){
        if(n==0)return 0;
        int digit=n%10;//last digit
        return armstrong_number(n/10,d)+pow(digit,d);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        int d=count_digit(n);
        int sum = armstrong_number(n, d); // Calculate the Armstrong sum

        // Check if the number is an Armstrong number
        if (sum == n) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }
}