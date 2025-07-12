import java.util.Scanner;
public class K_multi{
    //time and space complexity O(k)
    static void multiOf_k(int n,int k){
        if(k==0) return;
        multiOf_k(n,k-1);
        System.out.print(n*k+" ");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        System.out.println("Enter k: ");
        int k=sc.nextInt();
        multiOf_k(n,k);
    }
}