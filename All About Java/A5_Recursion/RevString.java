import java.util.Scanner;
public class RevString{
    static String Rev(String s,int index){
        if(index>=s.length())return "";
        return Rev(s,index+1)+s.charAt(index);

    }
    static boolean PalinDrome_WithoutRev(String s,int b,int e){
        if(b==e)return true;
        if(s.charAt(b)==s.charAt(e)){
            return PalinDrome_WithoutRev(s,b+1,e-1);
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        String ans = Rev(s,0);
        System.out.print(ans);
        if(ans.equals(s)){
            System.out.println("\nPlaindrom");
        }
        else{
            System.out.println("\nnot Plaindrom");
        }
        


    }
}