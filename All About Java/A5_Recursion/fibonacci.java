//current tern = prev + prev_prev

//subproblem= f(n-1),f(f-2)
//self work = f(n) = f(n-1)+f(n-2)
//base case = n==0 ->ans 0,n==1->ans 1
import java.util.Scanner; 
public class fibonacci{
    static int fib(int n){
        //base case
        if(n==0 || n==1)return n;
        //sub problem
        // int prev = fib(n-1);
        // int prevPrev= fib(n-2);
        // return prev+prevPrev;
        return fib(n-1)+fib(n-2);
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();

        for(int i=0;i<=n;i++){  
        System.out.print(fib(i)+" ");
        }
    }
}