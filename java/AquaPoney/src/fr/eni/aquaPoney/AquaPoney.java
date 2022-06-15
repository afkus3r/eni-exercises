package fr.eni.aquaPoney;

import java.util.Random;

public class AquaPoney {
    static char[] Bousquet = new char[25];
    static char[] LeVeau = new char[25];
    static char[] Dubosc = new char[25];
    static char ponyChar = '*';
    static Random random = new Random();

    public static void main(String[] args) {
        String BousquetString = initializePool(Bousquet);
        String LeVeauString = initializePool(LeVeau);
        String DuboscString = initializePool(Dubosc);

        displayPool(BousquetString, LeVeauString, DuboscString);
    }

    static String initializePool(char[] pony) {
        pony[0] = ponyChar;
        for (int i = 1; i < pony.length; i++) {
            pony[i] = ' ';
        }
        return new String(pony);
    }

    static void movePony(char[] pony, int i) {
        int randomIndex = random.nextInt(0, 3);
        pony[i + randomIndex] = ponyChar;
        pony[i] = ' ';
    }

    static void movePonyBack(char[] pony, int i) {
        int randomIndex = random.nextInt(0, 3);
        pony[i - randomIndex] = ponyChar;
        pony[i] = ' ';
    }

    static void displayPool(String a, String b, String c) {
        System.out.println("###########################");
        System.out.println("#" + a + "#");
        System.out.println("#" + b + "#");
        System.out.println("#" + c + "#");
        System.out.println("###########################");
    }
}