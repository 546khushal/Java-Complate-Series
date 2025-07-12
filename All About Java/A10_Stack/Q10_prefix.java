import java.util.*;
public class Q10_prefix {
    public static void main(String[] args) {
        String infix = "8-(5+3)*4/6";
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        System.out.println("infix : "+infix);
        for (int i = 0; i <infix.length(); i++) {
            char ch = infix.charAt(i);
            
            if (Character.isDigit(ch)) {
                String s= ""+ch;
                val.push(s);
            }
            else if (op.size()==0 || ch == '(' || op.peek()=='(') {
                op.push(ch);
            }
            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char operator = op.pop();
                    String t= operator+ v1 + v2;
                    val.push(t);
                }
                op.pop(); // Remove '('
            }
            else if (isOperator(ch)) {
                while (!op.isEmpty() && op.peek() != '(' && precedence(op.peek()) >= precedence(ch)) {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char operator = op.pop();
                    String t= operator+ v1 + v2;
                    val.push(t);
                }
                op.push(ch);
            }
        }

        while (!op.isEmpty()) {
            String v2 = val.pop();
            String v1 = val.pop();
            char operator = op.pop();
            String t= operator+ v1 + v2;
            val.push(t);    
        }
        String prefix = val.peek();
        System.out.println("prefix : "+prefix);
    


        //Evaluation prefix expression
        Stack<Integer> pre = new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            char ch=prefix.charAt(i);
            if (Character.isDigit(ch)) {
                int  s= Character.getNumericValue(ch);//(int)ch;
                pre.push(s);
            }else{//yha upper wala v1 kyu ulta loop chal rha hai
                int v1 = pre.pop();
                int v2 = pre.pop();
                char  ope = ch;
                pre.push(applyOp(v1,v2,ope));
            }
        }
        System.out.println("Evaluation is : "+pre.peek());

    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static int applyOp(int v1, int v2, char op) {
        switch (op) {
            case '+': return v1 + v2;
            case '-': return v1 - v2;
            case '*': return v1 * v2;
            case '/': return v1 / v2;
            default: return 0;
        }
    }

}