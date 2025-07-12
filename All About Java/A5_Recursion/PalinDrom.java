import java.util.Scanner;
public class PalinDrom{
    //TC=O(n*c)=>O(n)
    static boolean PalinDrome_WithoutRev(String s,int b,int e){
        if(b>=e)return true;
         return s.charAt(b)==s.charAt(e) && PalinDrome_WithoutRev(s,b+1,e-1);
        // if(s.charAt(b)==s.charAt(e)){
        //     return PalinDrome_WithoutRev(s,b+1,e-1);
        // }else{
        //     return false;
        // }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        
        if(PalinDrome_WithoutRev(s,0,s.length()-1)){
            System.out.println("\nPlaindrom");
        }
        else{
            System.out.println("\nnot Plaindrom");
        }
        


    }
}