/*TThe StringTokenizer class in Java, part of the java.util package, 
is used to break a string into tokens. 
It’s a legacy class that has been replaced by more modern approaches like the split() method in the String class or regular expressions.


Constructors
    StringTokenizer(String str):
        Uses default delimiters (space, tab, newline, carriage return).
    StringTokenizer(String str, String delim):
        Uses specified delimiters.
    StringTokenizer(String str, String delim, boolean returnDelims):
        If returnDelims is true, the delimiters are also treated as tokens.

Method: hasMoreTokens(),nextToken(),countTokens()
 */
import java.util.StringTokenizer;

public class A9_StringTokenizer {
    public static void main(String[] args) {
        // Input string
        String str = "Hello, this is a StringTokenizer example.";

        // Create a StringTokenizer with space as the delimiter
        StringTokenizer tokenizer = new StringTokenizer(str);
        /**
        Create a StringTokenizer with a comma as the delimiter
         String str = "Apple,Banana,Cherry,Grape";
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
         */
        
        // Count tokens
        System.out.println("Total Tokens: " + tokenizer.countTokens());

        // Iterate through tokens
        System.out.println("Tokens:");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
/*
Total Tokens: 6
Tokens:
Hello,
this
is
a
StringTokenizer
example. 



| Feature            | StringTokenizer            | `split()` Method           |
| ------------------ | -------------------------- | -------------------------- |
| **Thread-Safe**    | Yes                        | No                         |
| **Delimiter Type** | Single characters only     | Regular expressions        |
| **Performance**    | Slower                     | Faster                     |
| **Return Type**    | Iterates tokens one-by-one | Returns an array of tokens |

*/
