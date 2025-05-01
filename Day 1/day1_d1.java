//Refer the String class from Javadoc. Write program which will apply any 10 methods of the String class.
public class day1_d1 {            //StringMethods
    public static void main(String[] args) {
        String str = "  Hello, World! Java Programming is fun.  ";
        
        // 1. length() - Get the length of the string
        System.out.println("Length of the string: " + str.length());
        
        // 2. trim() - Remove leading and trailing spaces
        String trimmedStr = str.trim();
        System.out.println("Trimmed string: '" + trimmedStr + "'");
        
        // 3. toUpperCase() - Convert to uppercase
        System.out.println("Uppercase: " + trimmedStr.toUpperCase());
        
        // 4. toLowerCase() - Convert to lowercase
        System.out.println("Lowercase: " + trimmedStr.toLowerCase());
        
        // 5. substring() - Extract a substring
        System.out.println("Substring (7 to 12): " + trimmedStr.substring(7, 12));
        
        // 6. contains() - Check if the string contains a word
        System.out.println("Contains 'Java': " + trimmedStr.contains("Java"));
        
        // 7. replace() - Replace characters
        System.out.println("Replace 'Java' with 'Python': " + trimmedStr.replace("Java", "Python"));
        
        // 8. charAt() - Get the character at a specific index
        System.out.println("Character at index 7: " + trimmedStr.charAt(7));
        
        // 9. indexOf() - Find the first occurrence of a character
        System.out.println("Index of 'o': " + trimmedStr.indexOf('o'));
        
        // 10. split() - Split the string into an array
        String[] words = trimmedStr.split(" ");
        System.out.println("Words in the string:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
