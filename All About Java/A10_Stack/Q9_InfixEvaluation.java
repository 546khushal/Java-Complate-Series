import java.util.*;
public class Q9_InfixEvaluation {
    public static void main(String[] args) {
        String str = "8-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (Character.isDigit(ch)) {
                val.push(ch - '0');
            }
            else if (ch == '(') {
                op.push(ch);
            }
            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char operator = op.pop();
                    val.push(applyOp(v1, v2, operator));
                }
                op.pop(); // Remove '('
            }
            else if (isOperator(ch)) {
                while (!op.isEmpty() && op.peek() != '(' && 
                       precedence(op.peek()) >= precedence(ch)) {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char operator = op.pop();
                    val.push(applyOp(v1, v2, operator));
                }
                op.push(ch);
            }
        }

        while (!op.isEmpty()) {
            int v2 = val.pop();
            int v1 = val.pop();
            char operator = op.pop();
            val.push(applyOp(v1, v2, operator));
        }

        System.out.println(val.peek());
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