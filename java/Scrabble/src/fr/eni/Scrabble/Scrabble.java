package fr.eni.Scrabble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scrabble {
    static List<String> dictionaryWords = new ArrayList<String>();
    static int randomNumber = 0;
    static char[] randomWord = new char[20];
    static char[] shuffledLetters = new char[20];
    static boolean isLettersVerified;
    static boolean isWordVerified;

    public static void main(String[] args) {

    }

    static String[] createDictionaryArray() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("./dictionnaire.txt");
        Scanner fileScan = new Scanner(file);
        while (fileScan.hasNextLine()) {
            dictionaryWords.add(fileScan.nextLine());
        }
        return dictionaryWords.toArray(new String[0]);
    }
}
