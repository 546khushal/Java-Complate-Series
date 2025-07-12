//x=16->1,2,4,8,16
//y=12->1,2,3,4,6,12
//cd=1,2,4
//GDC=4
import java.util.Scanner;
public class GCD{
    static int gcd1(int x,int y){
        while(x%y!=0){
            int rem = x%y;
            x=y;
            y=rem;
        }
        return y;
    }
    //Euclid's algo
    //gcd(x,y)==gcd(y,x%y)
    //gcd(x,0)==x
    static int gcd(int x,int y){
        if(y==0)return x;
        return gcd(y,x%y);
    }

    static int lcm(int x,int y){
        return (x*y)/gcd(x,y);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = sc.nextInt();
        System.out.println("Enter y: ");
        int y = sc.nextInt();
        System.out.println("gcd: "+gcd1(x,y));
        System.out.println("gcd: "+gcd(x,y));
        System.out.println("lcm: "+lcm(x,y));
        
    }
}