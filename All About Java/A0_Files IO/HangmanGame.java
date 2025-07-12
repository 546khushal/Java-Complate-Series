import java.io.*;
import java.util.*;

public class HangmanGame {
    static final String FILE_NAME = "words.txt";
    static final int MAX_TRIES = 5;

    public static void main(String[] args) throws IOException {
        ensureWordsFileExists(); // Step 1: Write 10 words if file not found
        List<String> words = readWordsFromFile();
        String wordToGuess = pickRandomWord(words).toUpperCase();

        playHangman(wordToGuess);
    }

    // Step 1: Ensure file with 10 names exists
    static void ensureWordsFileExists() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            FileWriter fw = new FileWriter(file);
            fw.write("elephant\nzebra\ntiger\nlion\ngiraffe\nmonkey\npanther\ncheetah\nrabbit\nbuffalo");
            fw.close();
        }
    }

    // Step 2: Read names from file
    static List<String> readWordsFromFile() throws IOException {
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(new File(FILE_NAME));
        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        sc.close();
        return words;
    }

    // Step 3: Pick a random word
    static String pickRandomWord(List<String> words) {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    // Step 4: Hangman Logic
    static void playHangman(String wordToGuess) {
        Set<Character> guessed = new HashSet<>();
        Set<Character> revealed = getRandomRevealedLetters(wordToGuess);
        guessed.addAll(revealed);

        int wrongTries = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Guess the word! You have " + MAX_TRIES + " incorrect attempts.");

        while (wrongTries < MAX_TRIES) {
            boolean allGuessed = true;

            // Show current state of the word
            System.out.print("\nWord: ");
            for (char c : wordToGuess.toCharArray()) {
                if (guessed.contains(c)) {
                    System.out.print(c + " ");
                } else {
                    System.out.print("_ ");
                    allGuessed = false;
                }
            }

            if (allGuessed) {
                System.out.println("\nYou guessed the word: " + wordToGuess);
                return;
            }

            System.out.print("\nGuess a letter: ");
            char guess = Character.toUpperCase(sc.next().charAt(0));

            if (guessed.contains(guess)) {
                System.out.println("Already guessed!");
            } else if (wordToGuess.contains(String.valueOf(guess))) {
                guessed.add(guess);
                System.out.println("Correct!");
            } else {
                guessed.add(guess);
                wrongTries++;
                System.out.println("Wrong guess. Attempts left: " + (MAX_TRIES - wrongTries));
            }
        }

        System.out.println("\nGame Over! The word was: " + wordToGuess);
    }

    // Reveal 30% random letters
    static Set<Character> getRandomRevealedLetters(String word) {
        int length = word.length();
        int revealCount = Math.max(1, length * 30 / 100); // At least 1
        Set<Character> revealed = new HashSet<>();
        Random rand = new Random();

        while (revealed.size() < revealCount) {
            char randomChar = word.charAt(rand.nextInt(length));
            revealed.add(Character.toUpperCase(randomChar));
        }
        return revealed;
    }
}
