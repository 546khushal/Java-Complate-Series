import java.util.*;
public class Swaping{
    static void swap(int a,int b){
        System.out.println("org value before swap");
        System.out.println("a : "+a);
        System.out.println("b : "+b);
        int tmp=a;
            a=b;
            b=tmp;

        /*
        a=a+b;
        b=a-b;
        a=a-b;

        */

        System.out.println("org value After swap");
        System.out.println("a : "+a);
        System.out.println("b : "+b);

    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number first : ");
        int a=sc.nextInt();
        System.out.print("Enter number second : ");
        int b=sc.nextInt();
        swap(a,b);
    }
}