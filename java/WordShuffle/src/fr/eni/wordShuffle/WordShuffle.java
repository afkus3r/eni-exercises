package fr.eni.wordShuffle;

import java.util.Random;
import java.util.Scanner;

public class WordShuffle {
    public static void main(String[] args) {
        // Take sentence input from user
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Entrez une phrase :");
        String sentence = stringInput.nextLine();

        // Convert string into an array
        String[] words = sentence.split(" ");

        // Shuffle the words
        String shuffledSentence = "";
        for (String word : words) {
            shuffledSentence += shuffle(word) + " ";
        }

        // Display shuffled sentence
        System.out.println("Voici votre phrase mélangée :");
        System.out.println(shuffledSentence);
    }

    static String shuffle(String word) {
        // Convert string into an array
        char[] letters = word.toCharArray();

        // Shuffle
        Random random = new Random();
        for (int i = 1; i < letters.length - 1; i++) {
            char holder = letters[i];
            int randomNum = random.nextInt((letters.length - 2) + 1 - 1) + 1;
            letters[i] = letters[randomNum];
            letters[randomNum] = holder;
        }

        // Convert array back to string
        return new String(letters);
    }
}