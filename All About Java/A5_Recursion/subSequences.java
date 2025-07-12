/*1.Given a string,WAM to return all its subsequences in an arraylist.
A String is a subSequences of a given Strings that is generates by
 deleteing some character of a given String without changing its order
 input: abc
 output: a,b,c,ab,bc,ca,abc
 */

//2. without extra space

import java.util.Scanner;
import java.util.ArrayList;

public class subSequences{
    /*s="abc" */
    //use more extra space 2^n
    /*static ArrayList<String> getSSQ(String s){
        ArrayList<String> ans = new ArrayList<>();
        //base case
        if(s.length()==0){
            ans.add("");
            return ans;
        }
        char curr = s.charAt(0);
        ArrayList<String> smallAns = getSSQ(s.substring(1));//bc  smallans->["bc","b","c",""]
        //smallans=["bc","b","c",""]
        //ans = ["bc","abc","b","ab","c","ac","","a"]
        for(String ss:smallAns){
            ans.add(ss);//bc
            ans.add(curr+ss);//abc   a+bc
        }
        return ans;
    }*/

   //print subsequence use void function no more extra space
    static void PrintSSQ(String s,String currAns){
        
        if(s.length()==0){
            System.out.print(currAns+" ");
            return;
        }
        
        char curr = s.charAt(0);//a 
        String remString = s.substring(1);//bc
        //Curr char->chooses to be a part of currAns
        PrintSSQ(remString,currAns+curr);//bc,a
        //curr char->does not choose to be a part of currAns
        PrintSSQ(remString,currAns);//bc,""
    }




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.nextLine();
        /*ArrayList<String> ans=getSSQ(s);
        for(String ss:ans){
            System.out.print(ss+" ");
        }
        // System.out.print(ans);
        */
       PrintSSQ(s,"");
    }
}
