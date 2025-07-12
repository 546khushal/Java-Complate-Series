import java.util.Scanner;
public class n_to_1{
    static void PD(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        PD(n-1);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        PD(n);

    }
}