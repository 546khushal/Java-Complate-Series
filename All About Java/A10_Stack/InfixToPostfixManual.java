public class InfixToPostfixManual{
    private static final int SIZE = 50;

    static void push(char[] stack,int[] top,char operator){
        stack[++top[0]] = operator;//top[0] = top[0] + 1 or ++top[0] same hai
    }
    static char pop(char[] stack,int[] top){
        if(top[0]==-1){
            System.out.println("\nStack is Empty");
            return '\0';
        }
        return stack[top[0]--];
    }
    static char peep(char[] stack, int[] top) {
        if (top[0] == -1) {
            System.out.println("\nStack is Empty");
            return '\0';
        }
        return stack[top[0]];
    }
    static int priority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    static String infixToPostfix(String infix){
        char[] stack = new char[SIZE];
        int[] top={-1};//// Array of size 1 with the first element initialized to -1 across multiple methods without returning it explicitly.
        //here nnot use int top = -1; // A single integer variable initialized to -1 returning its new value after each stack operation.

        char[] postfix= new char[SIZE];
        int k=0;
        for(int i=0;i<infix.length();i++){
            char ss=infix.charAt(i);
            //1.if ss is operand->copy to output  //ascii = (int)ch
            if(Character.isLetterOrDigit(ss)){  //ascii>=48 && ascii<=57 
                postfix[k++]=ss;// (ascii-48)
            }
            //2.if ss is operator && top=-1 then push in stack
            else if(isOperator(ss) && top[0]== -1){
                push(stack,top,ss);
            }
            //3.if ss is operotr && stach[top]=='('->push
            else if(isOperator(ss) && stack[top[0]]=='('){
                push(stack,top,ss);
            }
             // 4. If ss is '(' -> push
            else if (ss == '(') {
                push(stack, top, ss);
            }
            // 5. If priority(ss) > priority(stack[top]) -> push
            else if (isOperator(ss) && priority(ss) > priority(peep(stack, top))) {
                push(stack, top, ss);
            }
            //6.if priority(ss)<=priority(stack[top])->pop & copy
            else if(isOperator(ss)){
                while(top[0]!=-1 && priority(ss)<=priority(peep(stack,top))){
                    postfix[k++]=pop(stack,top);
                }
                push(stack,top,ss);
            }
            // 7. If ss == ')' s-> pop & copy to output until '(' occurs & ignore '(' and ')'
            else if (ss == ')') {
                while (top[0] != -1 && peep(stack, top) != '(') {
                    postfix[k++] = pop(stack, top);
                }
                pop(stack, top); // Remove '('
            }
            i++;
        }
        // 8. If ss == '\0' -> pop & copy to output until top != -1
        while (top[0] != -1) {
            postfix[k++] = pop(stack, top);
        }

        return new String(postfix, 0, k); // Convert postfix array to string
    }

      public static void main(String[] args) {
        String infix = "((A+B)*C-(D/E+F)*G)";
        // String infix = "2+3*4";

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);
    }
}