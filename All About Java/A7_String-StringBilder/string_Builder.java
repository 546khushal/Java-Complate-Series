//problem in String ->interning,Immutability->poor performance
/*Important Constructors of StringBulider Class
StringBuilder()
StringBuilder(String str)
StringBuilder(int capacity)
 */
import java.util.*;
public class string_Builder{
    public static void main(String[] args){
        StringBuilder str = new StringBuilder("hello");
        //StringBuilder str = new StringBuilder(100);//use capacity
        //StringBuilder str = new StringBuilder();//Default Constructor capacity 16
        
        str.append(" world");
        System.out.println(str);//hello world

        //str.charAt(0)='D';//Error: becouse String immutable
        //posible here
        str.setCharAt(0,'D');//Dello world
        str.insert(6,"khushal ");//Dello khushal world
        str.deleteCharAt(6);//Dello hushal world
        //str.reverse();//dlrow lahsuh olleD
        str.delete(6,13);//Dello world
        
        System.out.println(str);

    System.out.println(str.indexOf("l"));//2
    System.out.println(str.substring(2,5));//llo

     char chh = 'a';
    System.out.println(Character.isLowerCase(chh)); // true
    System.out.println(Character.isUpperCase(chh)); // false



    StringBuilder sb = new StringBuilder("hello123");
    for (int i = 0; i < sb.length(); i++) {
        char c = sb.charAt(i);
        sb.setCharAt(i, Character.toUpperCase(c));
    }
    System.out.println(sb); // Output: "HELLO123"

    

    StringBuilder sbb = new StringBuilder("hello");
    String upperStr = sbb.toString().toUpperCase();
    System.out.println(upperStr);
    sbb = new StringBuilder(upperStr);

    System.out.println(sbb); // Output: "HELLO"
    }
}