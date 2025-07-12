import java.util.*;
public class string_begin{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str="Khushal suthar";
        String str2="Rohan";
        System.out.println(str);
        //takefrom user khushal suthar
        // System.out.println("Enter for s:");
        // String s=sc.next();
        // System.out.println(s);//->khushal
        
        // System.out.println("Enter for s2:");
        // sc.nextLine();
        // String s2=sc.nextLine();
        // System.out.println(s2);//->khushal suthar
        
        System.out.println(str.length());  //14
        System.out.println(str.charAt(2)); //u
        System.out.println(str.indexOf("u")+" "+str.indexOf("s"));//2  3
        /*"abc" compare to "abc"->0
        lexographically check krta hai
        abd>abc yha a,b same pr abd me d c se badha hai to positive result 1 hoga c se d ek badha
        */
        System.out.println(str.compareTo(str2));//-7  R badha hai K se 7 time
        System.out.println("abi".compareTo("abc"));//6 c se 6 ke baad i aata hai


        System.out.println(str.contains("sh"));//true
        
        System.out.println(str.startsWith("k"));//false
        System.out.println(str.startsWith("K"));//true
        System.out.println(str.endsWith("r"));//true

        System.out.println(str.toLowerCase());//khushal suthar
        System.out.println(str.toUpperCase());//KHUSHAL SUTHAR

        String s1="abc";
        String s2="def";
        System.out.println(s1.concat(s2));
    
        
        /*String + int/char/String  */
        String d1=str+" khushal";//Khushal suthar khushal
        String d2=str+2;//Khushal suthar2
        String d3=str+'g';//Khushal sutharg
        
        System.out.println("abc"+12);//abc12
        System.out.println("abc"+12+20);//abc1220
        System.out.println("abc"+(12+20));//abc32
        
        String sub="abcd";
        System.out.println(sub.substring(0,2));//ab
        System.out.println(sub.substring(0));//abcd
        System.out.println(sub.substring(2));//cd
        for(int i=1;i<4;i++){
            System.out.print(sub.substring(i)+" ");//bcd cd d
        }
        System.out.println();

        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=4;j++){
                //a ab abc abcd b bc bcd c cd d
                System.out.print(sub.substring(i,j)+" ");
            }
        }
    /***************** */
        //Intering and new (Memoery)
        String a="Hello";
        String a1="Hello";
        String b1="Hi";
        //a,a1 in stack/heap same address(like 500) point to save space
        //b1 is new address(like 222) in stack/heap
        String x = new String("Hello");//its use new address(like 700) 
        
        String c1="Hello";
        String c2="Hello";
        c2="Mello";
        System.out.println("\n"+c2);//->mello
        //first c1,c2 "Hello" point same address(200)
        //c2 change than point new address(300) or ydi c2="Hello" ko change kiya to memoery me rhdea baad me garbade collectior se ht jayeha

    /******************* */
    //Immutability of Strings
    String ss = "Hello";
    char ch= ss.charAt(1);
    //ss.charAt(0)='D';//Error: becouse its immutable
    System.out.println(ch+" "+ss);//e
    //ss="Dello"; //change hua but new address bna
    ss = ss.substring(0,0)+'D'+ss.substring(1);//yeh bhi new string hi banayehi
    System.out.println(ss);//Dello
//Why Immutability->Security,Interining ki vjh se vrna ek jgh change krne pr sb change ho jata like(ss.charAt(0)='D')
/*Performance of String->poor (immutability ki vjh se)
String str="a";->a
str+='b';->ab
str+='c';->abc   her bar nyi copy bn rhi hai

Performance badha skte hai String Builder ka use krke

*/

    System.out.println(str.equals(str2));  //false
    String g1="Khushal";
    String g2="Khushal";
    String g3=new String("Khushal");
    System.out.println(g1==g2);//true becouse same address than work ==
    System.out.println(g1==g3);//false becouse not at same address tha we use equals()
    System.out.println(g1.equals(g3));  //true
    


    }
}