/*Given a string the task is to toggle all the characters of the String 
intput: KhUshAl
output: kHuSHaL 
 */
import java.util.*;
public class toggle{
    //TC O(n^2) Sc O(n)
    static String Char_Toggle01(String s){
        String result="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int ascii = (int)ch;
            if(ascii>=97 && ascii<=122){
                ascii-=32;
                result +=(char)ascii;
            }else if(ascii >= 65 && ascii <= 90){
                ascii+=32;
                result += (char)ascii;
            }
        }
        return result;
    }
    
    //TC O(n) SC O(n)
    static String Char_Toggle(String s){
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='a' && chars[i]<='z'){
                chars[i]=(char)(chars[i]-32);
            }
            else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Uppercase to Lowercase
                chars[i] = (char) (chars[i] + 32);
        }
        }
        return new String(chars);

    }
    //O(n) O(n)
    static String Char_Toggle11(String str) {
        String result = "";
        int i = 0;
        char c = str.charAt(0); // Start with first character
        
        while (c != '\0') { // C-style null terminator check
            // Manual case detection and conversion
            if (c >= 'a' && c <= 'z') {
                // Convert lowercase to uppercase
                result += (char)(c - 32);
            } else if (c >= 'A' && c <= 'Z') {
                // Convert uppercase to lowercase
                result += (char)(c + 32);
            } else {
                // Keep non-alphabetic characters
                result += c;
            }
            
            try {
                c = str.charAt(++i); // Get next character
            } catch (StringIndexOutOfBoundsException e) {
                c = '\0'; // End of string
            }
        }
        
        return result;
    }
    //O(n) O(n)
    static String Char_Toggle2(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c); // Non-alphabetic characters
            }
        }
        return result.toString();
    }
    //O(n) O(n)  best Approach
    static String Char_Toggle3(String s) {
        // Convert the input string to a StringBuilder for in-place modification
        StringBuilder sb = new StringBuilder(s);
        
        // Iterate through each character in the StringBuilder
        for (int i = 0; i < sb.length(); i++) {
                char currentChar = sb.charAt(i);
                
                // Toggle the case of the current character
                if (Character.isLowerCase(currentChar)) {
                    sb.setCharAt(i, Character.toUpperCase(currentChar));
                } 
                else if (Character.isUpperCase(currentChar)) {
                    sb.setCharAt(i, Character.toLowerCase(currentChar));
                }
                // Non-alphabetic characters remain unchanged
            }
            
        // Convert the StringBuilder back to a String
        return sb.toString();
    }
    public static void main(String[] args){
        String s="KhUshAl suTHaR";
        System.out.println(Char_Toggle01(s));
        System.out.println(Char_Toggle(s));
        System.out.println(Char_Toggle11(s));
        System.out.println(Char_Toggle2(s));

        //Other way O(n)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String here: ");
        StringBuilder str=new StringBuilder(sc.nextLine());
        System.out.println(str);
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            
            // Check for lowercase letters (a-z)
            if(ascii >= 97 && ascii <= 122) {
                // Convert to uppercase
                ascii -= 32;
                str.setCharAt(i, (char)ascii);
            }
            // Check for uppercase letters (A-Z)
            else if(ascii >= 65 && ascii <= 90) {
                // Convert to lowercase
                ascii += 32;
                str.setCharAt(i, (char)ascii);
            }
            // All other characters (spaces, numbers, special chars) remain unchanged
        }
        System.out.println(str);
         

         


    }
}