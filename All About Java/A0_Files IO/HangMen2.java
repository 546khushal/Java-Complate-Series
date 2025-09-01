
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class HangMen2{
static final String FILE_NAME = "Heng.txt";
static Scanner sc = new Scanner(System.in);
        //write 10 word in file
        static void write10Word()  throws IOException{
            File file=new File("Heng.txt");
                    if(!file.exists()){
                        System.out.println("Enter 10 word to write in file: ");
                        FileWriter fw = new FileWriter(file);
                        for(int i=0;i<10;i++){
                            System.out.print("Enter word("+ (i+1) +"): ");
                            String word = sc.nextLine();
                            fw.write(word+"\n");
                        }
                        fw.close();
                    }    
                    
                
                    
        }
        static List<String> readWordFromFile() throws IOException{
            
                List<String> words = new ArrayList<>();
                Scanner sf = new Scanner(new File(FILE_NAME));
                while(sf.hasNextLine()){
                    String word = sf.nextLine().trim();
                    if(!word.isEmpty()){
                        words.add(word);
                    }
                }
            sf.close();
            return words;
                
            
        }

        static String pickRandomWord(List<String> words){
            Random rand = new Random();
            return words.get(rand.nextInt(words.size()));
        }

        static Set<Character> blankedWord(String word){
            int len = word.length();
            int blankCount = Math.max(1,len * 30/100 );
            Set<Character> blankword = new HashSet<>();
            Random rand  = new Random();
            while(blankword.size()<blankCount){
                char randomChar = word.charAt(rand.nextInt(len));
                blankword.add(Character.toUpperCase(randomChar));
            } 
            return blankword;
        }


        static void playHangmen(String wordGuess){
            Set<Character> guessed = new HashSet<>();
            Set<Character> blanked = blankedWord(wordGuess);
            guessed.addAll(blanked);
            int tries = 5;
            int wrong=0;
            System.out.println("Guess the word! You have "+ tries +": ");
            while(wrong<tries){
                boolean allGuessed=true;
                System.out.println("\nWord");
                for(char c:wordGuess.toCharArray()){
                    if(guessed.contains(c)){
                        System.out.print(c+" ");
                    }else{
                        System.out.print("_ ");
                        allGuessed =false;
                    }
                }
                if(allGuessed){
                    System.out.println("\n Yoy guessed the word: "+wordGuess);
                    return;
                }
                System.out.print("\nGuess a letter: ");
                char guess = Character.toUpperCase(sc.next().charAt(0));
                sc.nextLine();
                if(guessed.contains(guess)){
                    System.out.println("Already Gussed");
                }else if(wordGuess.contains(String.valueOf(guess))){
                    guessed.add(guess);
                    System.out.println("Correct");
                }else{
                    guessed.add(guess);
                    wrong++;
                    System.out.println("Wrong Guess. Attempt left"+ (tries-wrong));
                }
            }
            System.out.println("\nGame Over! The word was: " + wordGuess);
        }

        public static void main(String[] args) throws IOException{
            write10Word();//if file  not exit
            List<String> Words  = readWordFromFile();
            String randWord = pickRandomWord(Words).toUpperCase();
            playHangmen(randWord);

        }



}