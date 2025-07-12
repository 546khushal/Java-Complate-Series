import java.util.Scanner;
public class sumOfDigits{
    static int SOD(int n){
        if(n>=0 && n<=9)return n;
        return  SOD(n/10) + n%10;
    }
    static int CountD(int n){
        if(n>=0 && n<=9)return 1;
        return CountD(n/10)+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println(SOD(n));
        System.out.println(CountD(n));
    }
}