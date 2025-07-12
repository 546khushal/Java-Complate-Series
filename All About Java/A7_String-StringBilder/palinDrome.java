import java.util.*;
class palinDrome{
    static boolean palin(String s){
        StringBuilder str = new StringBuilder(s);
        /*str.reverse();
        String gtr = str+"";//StringBuilder to String
        return str.equals(gtr);
        */
       int i=0;
       int j=str.length()-1;
       while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
       }
       return true;
    }
    public static void main(String[] args){
        String str="abcdcba";
        System.out.println(palin(str));
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                if(palin(str.substring(i,j))==true){
                    System.out.print(str.substring(i,j)+" ");
                    count++;
                }
            }
        }
        System.out.println("\nThe number of palindrome substring: "+count);
    }
}