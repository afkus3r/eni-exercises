package fr.eni.wordShuffle;

import java.util.Random;
import java.util.Scanner;

public class WordShuffle {
    public static void main(String[] args) {
        // Takes sentence input from user
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Entrez une phrase :");
        String sentence = stringInput.nextLine();

        // Converts string into an array
        String[] words = sentence.split(" ");

        // Shuffles the words
        for (String word : words) {
            word = shuffle(word);
        }

        // Converts array back to string
        sentence = String.join(" ", words);

        // Display shuffled sentence
        System.out.println("Voici votre phrase mélangée :");
        System.out.println(sentence);
    }

    static String shuffle(String word) {
        // Convert string into an array
        char[] letters = word.toCharArray();

        // Shuffle
        Random random = new Random();
        for (int i = 1; i < letters.length - 2; i++) {
            char holder = letters[i];
            int randomNum = random.nextInt((letters.length - 2) + 1 - 1) + 1;
            letters[i] = letters[randomNum];
            letters[randomNum] = holder;
        }

        // Convert array back to string
        return new String(letters);
    }
}
