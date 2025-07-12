//p^q=p*p*p*p     q times
//p^q = p^q-1 *p 
import java.util.Scanner;
public class power_Q{

    //time complexity O(q)
    // static int pow(int p,int q){
    //     if(q==0)return 1;
    //     return pow(p,q-1)*p;
    // }

    //time complexity O(log q)
    static int pow(int p,int q){
        if(q==0)return 1;
        int smallpow= pow(p,q/2);
        if(q%2==0){
            return smallpow*smallpow;
        }else{
            return smallpow*smallpow*p;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter P: ");
        int p= sc.nextInt();
        System.out.println("Enter Q: ");
        int q=sc.nextInt();
        System.out.println(pow(p,q));
    }
}