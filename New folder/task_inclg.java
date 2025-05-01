import java.util.*;
public class task_inclg{

static void match(int a){
    int sa =a*a;
    int qa = a*a*a;
    String ts = String.valueOf(sa);
    String tq = String.valueOf(qa);
    String total=ts+tq;
    //System.out.println("your series square and cube:   "+  total);
    long ans=Long.parseLong(total);
    

    System.out.println("your series square and cube:   "+ ans);
    long count = total.length();
    if(count==10){
        System.out.println("10 digits present");
    }
    else{
        System.out.println("10 digit not present");
    }


}



 public static void main(String[] arge){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter number:");
    int number= sc.nextInt();
    match(number);
    

}




}
