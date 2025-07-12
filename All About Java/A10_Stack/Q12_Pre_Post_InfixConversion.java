import java.util.*;
class Q12_Pre_Post_InfixConversion{
    public static void main(String[] args){
        String prefix = "-8/*+5346";//postfix: 853+4*6/-

        Stack<String> postfix = new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            char ch=prefix.charAt(i);
            if(Character.isDigit(ch)){
                String s= ""+ch;
                postfix.push(s);
            }else{
                String v1 = postfix.pop();
                String v2 = postfix.pop();
                String ope= ch+"";
                String t =v1+v2+ope;
                postfix.push(t); 
            }
        }
    String postfixEvel=postfix.pop();
    System.out.println("Postfix Ecpression of prefix( "+ prefix +" )is: "+postfixEvel);
   
    //postfix to prefix
        Stack<String> pre = new Stack<>();
        for(int i=0;i<postfixEvel.length();i++){
            char ch=postfixEvel.charAt(i);
            if(Character.isDigit(ch)){
                String s= ""+ch;
                pre.push(s);
            }else{
                String v2 = pre.pop();
                String v1 = pre.pop();
                String ope= ch+"";
                String t =ope+v1+v2;
                pre.push(t); 
            }
        }
        String prefixEvel = pre.pop();
        System.out.println("Prefix Ecpression of postfix( "+ postfixEvel +" )is: "+prefixEvel);
    
    //postfix to infix
        Stack<String> infix = new Stack<>();
        for(int i=0;i<postfixEvel.length();i++){
            char ch=postfixEvel.charAt(i);
            if(Character.isDigit(ch)){
                String s= ""+ch;
                infix.push(s);
            }else{
                String v2 = infix.pop();
                String v1 = infix.pop();
                String ope= ch+"";
                String t ="("+ v1 + ope + v2 +")";
                //String t = v1 + ope + v2 ;
                
                infix.push(t); 
            }
        }
        String infixExpression = infix.pop();
        System.out.println("Infix Expression of postfix( "+ postfixEvel +" )is: "+infixExpression);
    

    }
}