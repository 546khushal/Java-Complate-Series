import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
public class inputout {
    public static void main(String []args)
    {
        throws IOException
        {
            int a,b,c;
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("enter a=");
            a=Integer.parseInt(buf.readline());
            System.out.print("enter b=");
            b=Integer.parseInt(buf.readline());       
            c=a+b;
            System.out.println(a,b+"="+c)
        }
    }
    
}
