//1.....WAP to check enter number is integer or not 
//2......write a program to calculate (GPA using mark of three sunject count of 100)
//3......WAP to convert kilometer to miles
import java.util.*;
public class practice_set1{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
    //1.......WAP to check enter number is integer or not 
        // System.out.println("enter check number:");
        // String input=sc.next();
        // isInteger(input);



    
    //2........write a program to calculate (GPA using mark of three sunject count of 100)
        //  System.out.println("enter sub1 mark:");
        // int sub1 =sc.nextInt();
        // System.out.println("enter sub2 mark:");
        // int sub2 =sc.nextInt();
        // System.out.println("enter sub3 mark:");
        // int sub3 =sc.nextInt();
        // float ans = gpaf(sub1,sub2,sub3);
        // System.out.printf("GPA: %.2f%n ", ans);

    //3......WAP to convert kilometer to miles
        System.out.println("enter km here:");
        int km=sc.nextInt();
        ml(km);

    }



       //1........WAP to check enter number is integer or not 
    public static void isInteger(String s){
       
        try{
             Integer.parseInt(s);
             System.out.printf("Entered number value '%s' is an integer.%n ",s);

        }
        catch (NumberFormatException e){
            System.out.printf("Entered number value '%s' is not an integer.%n ",s);
        }
        
    }

     //2......write a program to calculate (GPA using mark of three sunject count of 100)
    static float gpaf(int a, int b, int c){
    float gpaa =(((a/100.0f)*4.0f)+((b/100.0f)*4.0f)+((c/100.0f)*4.0f))/3;
    return gpaa;
    }

    //3......WAP to convert kilometer to miles
    static void ml(int a){
        double ans = a*0.62137119;
        
        System.out.println("km to miles output:"+ ans);
        System.out.println("Exiting program. Goodbye!");
        }

        

}