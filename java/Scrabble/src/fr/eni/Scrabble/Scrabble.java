package fr.eni.Scrabble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Scrabble {
    static List<String> dictionaryWords = new ArrayList<String>();
    static Random random = new Random();
    static String[] dictionary;
    static char[] randomWord;
    static char[] shuffledLetters;
    static String playerWord;

    public static void main(String[] args) {
        // Create array from dictionary
        dictionary = createDictionaryArray();

        // Get a random word from dictionary
        randomWord = getRandomWord(dictionary);

        // Shuffle random word's letters
        shuffledLetters = shuffleLetters(randomWord);

        // Display shuffled letters
        System.out.println(shuffledLetters);

        do {
            // Get player's input
            Scanner stringInput = new Scanner(System.in);
            System.out.println("Entrez un mot en utilisant les lettres tirées");
            playerWord = stringInput.nextLine();

            // Verify player's input and display result
            if (verifyLetters(playerWord.toCharArray(), shuffledLetters) && verifyWord(playerWord.toCharArray(), dictionary)) {
                System.out.println("Le mot le plus long possible est : " + Arrays.toString(randomWord));
            } else {
                System.out.println("Ce mot n'est pas conforme, recommencez");
            }

        } while (!verifyLetters(playerWord.toCharArray(), shuffledLetters) || !verifyWord(playerWord.toCharArray(), dictionary));
    }

    static String[] createDictionaryArray() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("./dictionnaire.txt");
        Scanner fileScan = new Scanner(file);
        while (fileScan.hasNextLine()) {
            dictionaryWords.add(fileScan.nextLine());
        }
        return dictionaryWords.toArray(new String[0]);
    }

    static char[] getRandomWord(String[] dictionary) {
        int randomInt = random.nextInt(dictionary.length);
        return dictionary[randomInt].toUpperCase().toCharArray();
    }

    static char[] shuffleLetters(char[] word) {
        for (int i = 0; i < word.length; i++) {
            char holder = word[i];
            int randomInt = random.nextInt(word.length);
            word[i] = word[randomInt];
            word[randomInt] = holder;
        }
        return word;
    }

    static boolean verifyLetters(char[] playerWord, char[] letters) {
        char[] playerWordCopy = Arrays.copyOf(playerWord, playerWord.length);
        char[] lettersCopy = Arrays.copyOf(letters, letters.length);
        Arrays.sort(playerWordCopy);
        Arrays.sort(lettersCopy);
        return Arrays.equals(playerWordCopy, lettersCopy);
    }

    static boolean verifyWord(char[] playerWord, String[] dictionary) {
        for (String word : dictionary) {
            if (Objects.equals(word, Arrays.toString(playerWord))) {
                return true;
            }
        }
        return false;
    }
}
