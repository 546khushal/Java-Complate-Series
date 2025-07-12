//check whether a iven bracket sequence is balanced or not
//()(()) -> true
//(()()( ->false
/*rules:-
opening ( ->push
closing )
    st top->( ->pop 
    if st is empty return false
 */   
import java.util.*;
class Q3_Balanced_brackets{
    public static boolean isBalanced(String str){
        Stack<Character> st = new Stack<>();
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                st.push(ch);
                count++;
            }else{//ch==')'
                if(st.size()==0)return false;
                if(st.peek()=='(') st.pop();
                count--;
            }
        }
        System.out.println("Balance different: "+count);
        if(st.size()>0)return false;
        return true;
    }

    //()[]{}
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{//ch==')'
                if(st.size()==0)return false;
                char top= st.peek();
                if((ch==')' && top=='(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')){
                   st.pop(); 
                }else{
                    return false;
                }
            }
        }
        if(st.size()>0)return false;
        return true;
    }
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //String str= "()(())";
        System.out.print("Enter String here: ");
        String str = sc.nextLine();
        System.out.println("is balanced? "+isBalanced(str));
    }
}