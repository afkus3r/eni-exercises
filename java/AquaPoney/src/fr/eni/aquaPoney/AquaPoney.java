package fr.eni.aquaPoney;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class AquaPoney {
    static String[] Bousquet = new String[25];
    static String[] LeVeau = new String[25];
    static String[] Dubosc = new String[25];
    static int counter1 = 0;
    static int counter2 = 0;
    static int counter3 = 0;
    static String ponyFront = "o>";
    static String ponyBack = "<o";
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner enterInput = new Scanner(System.in);
        int randomIndex = 0;
        String BousquetString = "";
        String LeVeauString = "";
        String DuboscString = "";
        displayPool(initializePool(Bousquet), initializePool(LeVeau), initializePool(Dubosc));

        do {
            String enter = enterInput.nextLine();
            if (Objects.equals(enter, "")) {
                randomIndex = random.nextInt(4);
                if (Objects.equals(Bousquet[counter1], "o>")) {
                    BousquetString = movePony(Bousquet, counter1, randomIndex);
                } else if (Objects.equals(Bousquet[counter1], "<o")) {
                    BousquetString = movePonyBack(Bousquet, counter1, randomIndex);
                }
                counter1 += randomIndex;

                randomIndex = random.nextInt(4);
                if (Objects.equals(LeVeau[counter2], "o>")) {
                    LeVeauString = movePony(LeVeau, counter2, randomIndex);
                } else if (Objects.equals(LeVeau[counter2], "<o")) {
                    LeVeauString = movePonyBack(LeVeau, counter2, randomIndex);
                }
                counter2 += randomIndex;

                randomIndex = random.nextInt(4);
                if (Objects.equals(Dubosc[counter3], "o>")) {
                    DuboscString = movePony(Dubosc, counter3, randomIndex);
                } else if (Objects.equals(Dubosc[counter3], "<o")) {
                    DuboscString = movePonyBack(Dubosc, counter3, randomIndex);
                }
                counter3 += randomIndex;

                displayPool(BousquetString, LeVeauString, DuboscString);
            }

        } while (!Objects.equals(Bousquet[0], "<o") && !Objects.equals(LeVeau[0], "<o") && !Objects.equals(Dubosc[0], "<o"));
    }

    static String initializePool(String[] pony) {
        pony[0] = ponyFront;
        for (int i = 1; i < pony.length; i++) {
            pony[i] = "  ";
        }
        return String.join("", pony);
    }

    static String movePony(String[] pony, int i, int index) {
        if (i + index < 24) {
            pony[i + index] = ponyFront;
        } else {
            pony[24] = ponyBack;
        }
        if (index == 0) {
            pony[i] = ponyFront;
        } else {
            pony[i] = "  ";
        }
        return String.join("", pony);
    }

    static String movePonyBack(String[] pony, int i, int index) {
        if (i - index > 0) {
            pony[i - index] = ponyBack;
        } else {
            pony[0] = ponyBack;
        }
        if (index == 0) {
            pony[i] = ponyBack;
        } else {
            pony[i] = "  ";
        }
        return String.join("", pony);
    }

    static void displayPool(String a, String b, String c) {
        System.out.println("######################################################");
        System.out.println("#" + a + "#");
        System.out.println("#" + b + "#");
        System.out.println("#" + c + "#");
        System.out.println("######################################################");
    }
}