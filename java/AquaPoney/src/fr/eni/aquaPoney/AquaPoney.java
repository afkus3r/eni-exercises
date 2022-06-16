package fr.eni.aquaPoney;

import java.util.Random;

public class AquaPoney {
    static String[] Bousquet = new String[25];
    static String[] LeVeau = new String[25];
    static String[] Dubosc = new String[25];
    static String ponyFront = "o>";
    static String ponyBack = "<o";
    static Random random = new Random();

    public static void main(String[] args) {
        displayPool(initializePool(Bousquet), initializePool(LeVeau), initializePool(Dubosc));
    }

    static String initializePool(String[] pony) {
        pony[0] = ponyFront;
        for (int i = 1; i < pony.length; i++) {
            pony[i] = " ";
        }
        return String.join("", pony);
    }

    static String movePony(String[] pony, int i) {
        int randomIndex = random.nextInt(4);
        if (i + randomIndex < 25) {
            pony[i + randomIndex] = ponyFront;
        } else {
            pony[24] = ponyBack;
        }
        pony[i] = " ";
        return String.join("", pony);
    }

    static String movePonyBack(String[] pony, int i) {
        int randomIndex = random.nextInt(4);
        if (i - randomIndex > 0) {
            pony[i + randomIndex] = ponyBack;
        } else {
            pony[0] = ponyBack;
        }
        pony[i] = " ";
        return String.join("", pony);
    }

    static void displayPool(String a, String b, String c) {
        System.out.println("###########################");
        System.out.println("#" + a + "#");
        System.out.println("#" + b + "#");
        System.out.println("#" + c + "#");
        System.out.println("###########################");
    }
}