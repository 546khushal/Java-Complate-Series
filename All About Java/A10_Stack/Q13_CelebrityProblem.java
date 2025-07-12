 /*A celebrity is a person who is known to all but does not know anyone at a party. 
 A party is being organized by some people. 
 A square matrix mat[][] (n*n) is used to represent people at the party 
 such that if an element of row i and column j is set to 1 it means ith person knows jth person. 
 You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.
Examples:
Input: mat[][] = [[1, 1, 0], 
                  [0, 1, 0], 
                  [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person. Therefore, 1 is the celebrity person. 
*/
import java.util.Stack;

class Q13_CelebrityProblem {
    public static  int celebrity(int M[][]) {
        int n = M.length; // Get size from matrix dimensions
        
        Stack<Integer> stack = new Stack<>();
        
        // Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);// Har person ka index stack mein daal do
        }
        
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            /// Agar 'a', 'b' ko jaanta hai to 'a' celebrity nahi ho sakta
            if (M[a][b] == 1) {
                stack.push(b);// 'b' ko wapas stack mein daalo
            }
            /// Warna 'b' celebrity nahi ho sakta
            else {
                stack.push(a);// 'a' ko wapas stack mein daalo
            }
        }
        // Agar stack khali hai to koi celebrity nahi hai
        if (stack.isEmpty()) {
            return -1;
        }
        
        int potential = stack.pop();// Stack mein bacha hua last person potential celebrity hai
        
        // Verify potential celebrity
        for (int i = 0; i < n; i++) {
            // Celebrity kisi ko nahi jaanta (khud ko chhod kar)
            if (i != potential && M[potential][i] == 1) {
                return -1;
            }
            // Sabhi log celebrity ko jaante hain (khud ko chhod kar)
            if (i != potential && M[i][potential] == 0) {
                return -1;
            }
        }
        
        return potential;
    }

    public static void main(String[] args){
        int[][] matrix = {
                            {0, 1, 0},// Person 0: 1 ko jaanta hai
                            {0, 0, 0}, // Person 1: Kisi ko nahi jaanta (potential celebrity)
                            {0, 1, 0}// Person 2: 1 ko jaanta hai
                        };
        int celeb = celebrity(matrix); // Returns 1 (the celebrity)
        System.out.println(celeb);
    }
}
