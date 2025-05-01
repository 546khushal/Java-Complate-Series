// Refer the StringBuffer class from Javadoc. Write program which will apply any 5 methods of the StringBuffer class.
public class day1_d2 {              //StringBufferMethods
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello, World!");
        
        // 1. append() - Append text to the end
        sb.append(" Welcome to Java.");
        System.out.println("After append: " + sb);
        
        // 2. insert() - Insert text at a specific index
        sb.insert(7, "Beautiful ");
        System.out.println("After insert: " + sb);
        
        // 3. replace() - Replace a portion of the string
        sb.replace(7, 16, "Amazing");
        System.out.println("After replace: " + sb);
        
        // 4. reverse() - Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // 5. delete() - Delete a portion of the string
        sb.reverse(); // Reverse again to restore original order
        sb.delete(13, 21);
        System.out.println("After delete: " + sb);
    }
}
