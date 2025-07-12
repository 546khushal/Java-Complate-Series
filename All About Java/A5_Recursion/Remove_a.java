//Remove all the occurrences of a from string s = "abcdx"
import java.util.Scanner;

public class Remove_a{
    /*static String Remove_A(String s){
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != 'a' && s.charAt(i)!='A'){
                ans+=s.charAt(i);
            }
        }
        return ans;
    }*/
   //tc=no of calls * time taken in 1 call
   //     n*constant time+n(return currChar+smallAns;)
   //tc=  O(n*n)
   //tc = O(n^2)
    static String Remove_A(String s,int index){
        //base case
        if(index>=s.length())return "";
        //recursive work
        String smallAns = Remove_A(s,index+1);
        char currChar = s.charAt(index);
        //self work
        if(currChar!='a' && currChar!='A'){
            return currChar+smallAns;
        }else{
            return smallAns;
        }

    }
    //without use index
    //tc= n*n(substring)+(return currChar+smallAns;)
    //tc=O(2n^2) 
    //tc=O(n^2)
    static String Remove_A2(String s){
        //base case
        if(s.length()==0)return "";
        //recursive work
        String smallAns = Remove_A2(s.substring(1));
        char currChar = s.charAt(0);
        //self work
        if(currChar!='a' && currChar!='A'){
            return currChar+smallAns;
        }else{
            return smallAns;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        String ans = Remove_A(s,0);
        //String ans = Remove_A2(s);
        // for(int i=0;i<ans.length();i++){
        //     System.out.print(ans.charAt(i));
        // }
        System.out.print(ans);

    }
}