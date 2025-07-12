import java.util.Scanner;

public class StringOperations {
    
    // Convert to uppercase
    public static void upper(char[] str) {
        for(int i = 0; i < str.length; i++) {
            if(str[i] >= 'a' && str[i] <= 'z') {
                str[i] = (char)(str[i] - 32);
            }
        }
    }
    
    // Convert to lowercase
    public static void lower(char[] str) {
        for(int i = 0; i < str.length; i++) {
            if(str[i] >= 'A' && str[i] <= 'Z') {
                str[i] = (char)(str[i] + 32);
            }
        }
    }
    
    // String concatenation
    public static char[] strcat(char[] dest, char[] src) {
        char[] result = new char[dest.length + src.length];
        System.arraycopy(dest, 0, result, 0, dest.length);
        System.arraycopy(src, 0, result, dest.length, src.length);
        return result;
    }
    
    // String copy
    public static char[] strcpy(char[] dest, char[] src) {
        char[] result = new char[src.length];
        System.arraycopy(src, 0, result, 0, src.length);
        return result;
    }
    
    // String length
    public static int strlen(char[] str) {
        return str.length;
    }
    
    // String reverse
    public static void strrev(char[] str) {
        int i = 0, j = str.length - 1;
        while(i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    
    // Proper case conversion
    public static void proper(char[] str) {
        boolean flag = false;
        if(str.length > 0 && str[0] >= 'a' && str[0] <= 'z') {
            str[0] = (char)(str[0] - 32);
        }
        
        for(int i = 1; i < str.length; i++) {
            if(str[i] == ' ') {
                flag = true;
            }
            if(str[i] >= 'A' && str[i] <= 'Z' && !flag) {
                str[i] = (char)(str[i] + 32);
            }
            if(str[i] >= 'a' && str[i] <= 'z' && flag) {
                str[i] = (char)(str[i] - 32);
                flag = false;
            }
        }
    }
    
    // Find character
    public static boolean find(char[] str, char cv) {
        for(char c : str) {
            if(c == cv) return true;
        }
        return false;
    }
    
    // String comparison
    public static int strcmp(char[] p, char[] q) {
        int minLength = Math.min(p.length, q.length);
        for(int i = 0; i < minLength; i++) {
            if(p[i] != q[i]) {
                return p[i] - q[i];
            }
        }
        return p.length - q.length;
    }
    
    // Check palindrome
    public static boolean isPalindrome(char[] str) {
        char[] temp = str.clone();
        strrev(temp);
        return strcmp(str, temp) == 0;
    }
    
    // Delete character
    public static char[] delete(char[] str, char ch) {
        int count = 0;
        for(char c : str) {
            if(c == ch) count++;
        }
        
        char[] result = new char[str.length - count];
        int index = 0;
        for(char c : str) {
            if(c != ch) {
                result[index++] = c;
            }
        }
        return result;
    }
    
    // Trim spaces
    public static char[] trim(char[] str) {
        int start = 0, end = str.length - 1;
        
        while(start <= end && str[start] == ' ') start++;
        while(end >= start && str[end] == ' ') end--;
        
        if(start > end) return new char[0];
        
        return String.valueOf(str).substring(start, end + 1).toCharArray();
    }
    
    // Replace character
    public static void replace(char[] str, char s, char d) {
        for(int i = 0; i < str.length; i++) {
            if(str[i] == s) {
                str[i] = d;
            }
        }
    }
    
    // Find substring
    public static boolean strFind(char[] str, char[] str1) {
        if(str1.length == 0) return true;
        if(str.length < str1.length) return false;
        
        for(int i = 0; i <= str.length - str1.length; i++) {
            boolean found = true;
            for(int j = 0; j < str1.length; j++) {
                if(str[i + j] != str1[j]) {
                    found = false;
                    break;
                }
            }
            if(found) return true;
        }
        return false;
    }
    
    // Display menu
    public static void menu() {
        System.out.println("\n1..String length");
        System.out.println("2..String Copy");
        System.out.println("3..String Concatenate");
        System.out.println("4..Lower Case");
        System.out.println("5..Upper Case");
        System.out.println("6..Proper Case");
        System.out.println("7..Reverse");
        System.out.println("8..Palindrome");
        System.out.println("9..String Compare");
        System.out.println("10..Find character");
        System.out.println("11..Delete character");
        System.out.println("12..Replace character");
        System.out.println("13..Remove extra space");
        System.out.println("14..Find String");
        System.out.println("15..Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch;
        char[] str = new char[0];
        char[] str1 = new char[0];
        char[] str2 = "Hello ".toCharArray();
        
        do {
            System.out.println("\nCurrent string: " + (str.length > 0 ? new String(str) : "<empty>"));
            menu();
            ch = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch(ch) {
                case 1: // strlen
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Length of string: " + strlen(str));
                    break;
                    
                case 2: // strcpy
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Source string: " + new String(str));
                    str1 = strcpy(new char[str.length], str);
                    System.out.println("Copied string: " + new String(str1));
                    break;
                    
                case 3: // strcat
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("String to concatenate: " + new String(str));
                    str2 = strcat(str2, str);
                    System.out.println("Result after concatenation: " + new String(str2));
                    break;
                    
                case 4: // lower
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Original string: " + new String(str));
                    lower(str);
                    System.out.println("Lowercase string: " + new String(str));
                    break;
                    
                case 5: // upper
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Original string: " + new String(str));
                    upper(str);
                    System.out.println("Uppercase string: " + new String(str));
                    break;
                    
                case 6: // proper
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Original string: " + new String(str));
                    proper(str);
                    System.out.println("Proper case string: " + new String(str));
                    break;
                    
                case 7: // reverse
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Original string: " + new String(str));
                    strrev(str);
                    System.out.println("Reversed string: " + new String(str));
                    break;
                    
                case 8: // palindrome
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println(isPalindrome(str) ? "Palindrome" : "Not palindrome");
                    break;
                    
                case 9: // strcmp
                    System.out.print("Enter first string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.print("Enter second string: ");
                    str1 = scanner.nextLine().toCharArray();
                    int cmp = strcmp(str, str1);
                    if(cmp == 0) {
                        System.out.println("Strings are equal");
                    } else {
                        System.out.println("Strings are not equal");
                    }
                    break;
                    
                case 10: // find char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.print("Enter character to find: ");
                    char cv = scanner.nextLine().charAt(0);
                    System.out.println(find(str, cv) ? "Character found" : "Character not found");
                    break;
                    
                case 11: // delete char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.print("Enter character to delete: ");
                    char delChar = scanner.nextLine().charAt(0);
                    str = delete(str, delChar);
                    System.out.println("String after deletion: " + new String(str));
                    break;
                    
                case 12: // replace char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.print("Enter character to replace: ");
                    char s = scanner.nextLine().charAt(0);
                    System.out.print("Enter replacement character: ");
                    char d = scanner.nextLine().charAt(0);
                    replace(str, s, d);
                    System.out.println("String after replacement: " + new String(str));
                    break;
                    
                case 13: // trim
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.println("Original string: " + new String(str));
                    str = trim(str);
                    System.out.println("Trimmed string: " + new String(str));
                    break;
                    
                case 14: // find string
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine().toCharArray();
                    System.out.print("Enter search string: ");
                    str1 = scanner.nextLine().toCharArray();
                    System.out.println(strFind(str, str1) ? "Substring found" : "Substring not found");
                    break;
                    
                case 15: // exit
                    System.out.println("Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
            
            if(ch != 15) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        } while(ch != 15);
        
        scanner.close();
    }
}