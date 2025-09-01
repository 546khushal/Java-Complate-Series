import java.util.*;

class HangMan{
    static Scanner sc = new Scanner(System.in);
    
    static String BlankWord(String s) {
        StringBuilder word = new StringBuilder(s);
        StringBuilder newword = new StringBuilder("");
        Random random = new Random();
        
        // First ensure we reveal at least 3 characters
        int reveal1 = 0; // Always show first character
        int reveal2 = random.nextInt(word.length() - 2) + 1; // Random middle position
        int reveal3 = word.length() - 1; // Always show last character
        
        for(int i = 0; i < word.length(); i++) {
            if(i == reveal1 || i == reveal2 || i == reveal3) {
                newword.append(word.charAt(i));
            } else {
                // Randomly decide to show some extra characters (20% chance)
                if(random.nextInt(5) == 0 && word.length() > 5) { 
                    newword.append(word.charAt(i));
                } else {
                    newword.append("_");
                }
            }
        }
        return newword.toString();
    }
    static void Matching(String o,String b){
        StringBuilder complate = new StringBuilder(o);
        StringBuilder blank = new StringBuilder(b);
        int tries = 0;
        int maxTries = 5;
        for(int i=0;i<o.length();i++){
            if(i == 0 || i == o.length()/2 || i == o.length()-1) {
                continue;
            }
            if(tries >= maxTries) { // Added trial check
                System.out.println("You've used all your tries!");
                break;
            }
            System.out.println(" Guess this word: " + blank);
            System.out.println("Tries left: " + (maxTries - tries)); 
            System.out.println("Enter char: ");
            char g = sc.next().toLowerCase().charAt(0);
            
            
                    
            if(complate.charAt(i)==g){
                blank.setCharAt(i,g);
                System.out.println("match hai ");
            }
            else{
                System.out.println("match nahi hai ");
                i--;
                tries++;
            }
            System.out.println("Current: " + blank.toString());
        }
        if(tries < maxTries) {
            System.out.println("Congratulations! You guessed the word: " + o);
        } else {
            System.out.println("Game Over! The word was: " + o);
        }
    }
    public static void main(String[] args){
        String[] arr={"khushal","harish","Rohit","manmohan","shivlal"};
        Random random = new Random();
        int idx = random.nextInt(arr.length);
        String word=arr[idx];
        String blankWord = BlankWord(word);
         System.out.println(word+" Guess this word: " + blankWord);
        Matching(word, blankWord);
    }
}
