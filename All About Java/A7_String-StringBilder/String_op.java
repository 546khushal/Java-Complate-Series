import java.util.Scanner;

public class String_op {
    
    // Convert to uppercase
    public static String upper(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z') {
                result += (char)(c - 32);
            } else {
                result += c;
            }
        }
        return result;
    }
    
    // Convert to lowercase
    public static String lower(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                result += (char)(c + 32);
            } else {
                result += c;
            }
        }
        return result;
    }
    
    // String concatenation
    public static String strcat(String dest, String src) {
        String result = "";
        for(int i = 0; i < dest.length(); i++) {
            result += dest.charAt(i);
        }
        for(int i = 0; i < src.length(); i++) {
            result += src.charAt(i);
        }
        return result;
    }
    
    // String copy
    public static String strcpy(String dest, String src) {
        String result = "";
        for(int i = 0; i < src.length(); i++) {
            result += src.charAt(i);
        }
        return result;
    }
    
    // String length
    public static int strlen(String str) {
        return str.length(); // Keeping this as it's fundamental
    }
    
    // String reverse
    public static String strrev(String str) {
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    // Proper case conversion
    public static String proper(String str) {
        if(str.length() == 0) return str;
        
        String result = "";
        boolean newWord = true;
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(newWord && c >= 'a' && c <= 'z') {
                result += (char)(c - 32);
                newWord = false;
            } else if(!newWord && c >= 'A' && c <= 'Z') {
                result += (char)(c + 32);
            } else {
                result += c;
            }
            
            if(c == ' ') {
                newWord = true;
            }
        }
        return result;
    }
    
    // Find character
    public static boolean find(String str, char cv) {
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == cv) {
                return true;
            }
        }
        return false;
    }
    
    // String comparison
    public static int strcmp(String p, String q) {
        int minLength = p.length() < q.length() ? p.length() : q.length();
        for(int i = 0; i < minLength; i++) {
            if(p.charAt(i) != q.charAt(i)) {
                return p.charAt(i) - q.charAt(i);
            }
        }
        return p.length() - q.length();
    }
    
    // Check palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Delete character
    public static String delete(String str, char ch) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ch) {
                result += str.charAt(i);
            }
        }
        return result;
    }
    
    // Trim spaces
    public static String trim(String str) {
        if(str.length() == 0) return str;
        
        int start = 0;
        int end = str.length() - 1;
        
        while(start <= end && str.charAt(start) == ' ') start++;
        while(end >= start && str.charAt(end) == ' ') end--;
        
        if(start > end) return "";
        
        String result = "";
        for(int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    
    // Replace character
    public static String replace(String str, char s, char d) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == s) {
                result += d;
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
    
    // Find substring
    public static boolean strFind(String str, String str1) {
        if(str1.length() == 0) return true;
        if(str.length() < str1.length()) return false;
        
        for(int i = 0; i <= str.length() - str1.length(); i++) {
            boolean found = true;
            for(int j = 0; j < str1.length(); j++) {
                if(str.charAt(i + j) != str1.charAt(j)) {
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
        String str = "";
        String str1 = "";
        String str2 = "Hello ";
        
        do {
            System.out.println("\nCurrent string: " + (str.length() == 0 ? "<empty>" : str));
            menu();
            ch = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch(ch) {
                case 1: // strlen
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Length of string: " + strlen(str));
                    break;
                    
                case 2: // strcpy
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Source string: " + str);
                    str1 = strcpy("", str);
                    System.out.println("Copied string: " + str1);
                    break;
                    
                case 3: // strcat
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("String to concatenate: " + str);
                    str2 = strcat(str2, str);
                    System.out.println("Result after concatenation: " + str2);
                    break;
                    
                case 4: // lower
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Original string: " + str);
                    str = lower(str);
                    System.out.println("Lowercase string: " + str);
                    break;
                    
                case 5: // upper
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Original string: " + str);
                    str = upper(str);
                    System.out.println("Uppercase string: " + str);
                    break;
                    
                case 6: // proper
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Original string: " + str);
                    str = proper(str);
                    System.out.println("Proper case string: " + str);
                    break;
                    
                case 7: // reverse
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Original string: " + str);
                    str = strrev(str);
                    System.out.println("Reversed string: " + str);
                    break;
                    
                case 8: // palindrome
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println(isPalindrome(str) ? "Palindrome" : "Not palindrome");
                    break;
                    
                case 9: // strcmp
                    System.out.print("Enter first string: ");
                    str = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    str1 = scanner.nextLine();
                    int cmp = strcmp(str, str1);
                    if(cmp == 0) {
                        System.out.println("Strings are equal");
                    } else {
                        System.out.println("Strings are not equal");
                    }
                    break;
                    
                case 10: // find char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.print("Enter character to find: ");
                    char cv = scanner.nextLine().charAt(0);
                    System.out.println(find(str, cv) ? "Character found" : "Character not found");
                    break;
                    
                case 11: // delete char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.print("Enter character to delete: ");
                    char delChar = scanner.nextLine().charAt(0);
                    str = delete(str, delChar);
                    System.out.println("String after deletion: " + str);
                    break;
                    
                case 12: // replace char
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.print("Enter character to replace: ");
                    char s = scanner.nextLine().charAt(0);
                    System.out.print("Enter replacement character: ");
                    char d = scanner.nextLine().charAt(0);
                    str = replace(str, s, d);
                    System.out.println("String after replacement: " + str);
                    break;
                    
                case 13: // trim
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.println("Original string: " + str);
                    str = trim(str);
                    System.out.println("Trimmed string: " + str);
                    break;
                    
                case 14: // find string
                    System.out.print("Enter any string: ");
                    str = scanner.nextLine();
                    System.out.print("Enter search string: ");
                    str1 = scanner.nextLine();
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