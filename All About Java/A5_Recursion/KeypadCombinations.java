/**Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

Input: digits = "23"

Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"] */
public class KeypadCombinations{
    //yadi 779 jisme 4 char hai worst case
    //to level 0 ->4^0, l1->4^1,l2->4^2,l3->4^3
    //4^0+4^1+4^2+4^3....4^n
    //4^n
    //loop 4 bar chalta hai or substring+concate 2n hua
    //4*n=n(ignore constant)
    // ek cakk me time lagta hai O(n)
    //total call 4^n
    //TC = O(n.4^n)
    static void combination(String dig,String[] kp,String res){//'253'->kp[2]
        if(dig.length()==0){
            System.out.print(res+" ");
            return;
        }
        int currNum=dig.charAt(0)-'0';//'2'->2 str se num 
        String currChoice = kp[currNum];//"abc"

        for(int i=0;i<currChoice.length();i++){
            combination(dig.substring(1),kp,res + currChoice.charAt(i));
        }
    }
    public static void main(String[] args){
        String dig= "253";
        String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
              //      0  1    2    3     4      5    6     7      8     9      
        combination(dig,kp,"");
    }
}