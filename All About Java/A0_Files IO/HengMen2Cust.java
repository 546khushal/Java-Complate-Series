import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class HengMen2Cust{
    static final String FILE_NAME="hengMen.txt";
    
    static String readInput(){
        char[] input = new char[100];
        int index=0;
        try{
            int ch;
            while((ch=System.in.read())!='\n' && ch!=-1 && index<99){
                input[index++]=(char)ch;
            }
        }catch(IOException e){
            System.out.println("Input Error");
        }
        input[index]='\0';
        return new String(input, 0, index);
    }

    static String toUpper(String s){
        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                arr[i]=(char)(c-32);
            }
            else{
                arr[i]=c;
            }
        }
        return new String(arr);
    }

    static int strLength(String s){
        int length = 0;
        try{
            while(true){
                s.charAt(length);
                length++;
            }
        }catch(Exception e){

        }
        return length;
    }

    //Write 10 word to file
    static void write10Word(){
        File file= new File(FILE_NAME);
        if(!file.exists()){
            try{
                FileWriter fw = new FileWriter(file);
                System.out.println("Enter 10 words to write in file: ");
                for(int i=1;i<=10;i++){
                    System.out.print("Enter word("+i+"): ");
                    String word = toUpper(readInput());
                    if(strLength(word)>0){
                        fw.write(word+"\n");
                    }
                }
                fw.close();
                System.out.println("Word saved to file Successfully");
            }catch(IOException e){
                System.out.println("File error");
            }
        }
    }


    //Read word from file into array
    static String[] readWordsFromFile() {
        String[] words = new String[10];
        int wordCount=0;
        try{
            FileReader fr = new FileReader(FILE_NAME);
            char[] fileread = new char[1000];

            int charsRead = fr.read(fileread);
            fr.close();
            if(charsRead<=0){
                return new String[0];//Empty file
            }
            int start=0;
            for(int i=0;i<charsRead;i++){
                if(fileread[i]=='\n' || i==charsRead-1){
                    int end=i;
                    if(i==charsRead-1 && fileread[i]!='\n'){
                        end=i+1;
                    }

                    //Extract word from file
                    int wordlength = end-start;
                    if(wordlength>0){
                        char[] wordChars = new char[wordlength];
                        for(int j=0;j<wordlength;j++){
                            wordChars[j]=fileread[start+j];
                        }
                        String word=new String(wordChars).trim();
                        if(strLength(word)>0 && wordCount<words.length){
                            words[wordCount++]=word;
                        }
                    }
                    start=i+1;//move to next word
                }
            }
        }catch(IOException e){
            System.out.println("Error redding file: "+e.getMessage());
        }

        String[] result = new String[wordCount];
        for(int i=0;i<wordCount;i++){
            result[i]=words[i];
        }
        return result;
    }


        static String pickRandomWord(String[] words){
            int index=(int)(Math.random()*words.length);
            return words[index];
        }

    //create blanked word position
    static String createBlankedWord(String word){
        int len = strLength(word);
        int blankCount = (len*30)/100;
        if(blankCount<1)blankCount=1;

        //array for blanked word
        char[] result = new char[len];

        for(int i=0;i<len;i++){
            result[i]='_';
        }
        int blank=0;
        while(blank<blankCount){
            int pos = (int)(Math.random()*len);
            if(result[pos]=='_'){
                result[pos]=word.charAt(pos);
                blank++;
            }
        }
        return new String(result);
        
    }


    static void playHangman(String word){
        Scanner sc = new Scanner(System.in);
        int tries =5;
        int wrong=0;
        String current = createBlankedWord(word);
        String guessletters = "";
        System.out.println("\n===Hangman Game===");
        System.out.println("Guess the word! You have " + tries + " tries");
        System.out.println("Word has " + word.length() + " letters");
        while(wrong<tries){
            System.out.println("\nWord: "+current);
            System.out.println("Guessed letters: " + guessletters);
            System.out.println("Attempts left: " + (tries - wrong));
            
            if(!current.contains("_")){
                System.out.println("Congratulations! you won");
                System.out.println("word is : "+word);
                return;
            }

            System.out.print("Guess a letter: ");
            char guess= sc.next().toUpperCase().charAt(0); 
            sc.nextLine();
            if(guessletters.indexOf(guess)!=-1){
                System.out.println("you Already guessed '"+guess+"'");
                continue;
            }
            if(word.indexOf(guess)!=-1){
                System.out.println("Correct "+guess+" is in the word");
                //update current
                char[] newState=current.toCharArray();
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)==guess){
                        newState[i]=guess;
                    }
                }
                current = new String(newState);
            }else{
                wrong++;
                System.out.println("Wrong "+guess+" is not in word");
            }
        }
        System.out.println("\n Game Over! You out of attempts");
        System.out.println("The word was: " + word);
        

    }

    public static void main(String[] args){
        write10Word();
        String[] words=readWordsFromFile();
        String randomWord = pickRandomWord(words);
        playHangman(randomWord); 
    }
}