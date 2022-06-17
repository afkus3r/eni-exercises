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
        int randomIndex;
        String BousquetString = "";
        String LeVeauString = "";
        String DuboscString = "";

        // Initialize and display pool for the start
        displayPool(initializePool(Bousquet), initializePool(LeVeau), initializePool(Dubosc));

        do {
            // Let user press enter key
            String enter = enterInput.nextLine();
            if (Objects.equals(enter, "")) {

                // FIRST PONY
                randomIndex = random.nextInt(4);
                // Make the pony move forward
                if (Objects.equals(Bousquet[counter1], "o>")) {
                    BousquetString = movePony(Bousquet, counter1, randomIndex);
                    if (counter1 + randomIndex < 24) {
                        counter1 += randomIndex;
                    } else {
                        counter1 = 24;
                    }
                    // Make the pony move backward
                } else if (Objects.equals(Bousquet[0], "<o")) {
                    Bousquet[0] = "<0";
                    break;
                } else if (Objects.equals(Bousquet[counter1], "<o")) {
                    BousquetString = movePonyBack(Bousquet, counter1, randomIndex);
                    if (counter1 - randomIndex > 0) {
                        counter1 -= randomIndex;
                    } else {
                        counter1 = 0;
                    }
                }

                // SECOND PONY
                randomIndex = random.nextInt(4);
                // Make the pony move forward
                if (Objects.equals(LeVeau[counter2], "o>")) {
                    LeVeauString = movePony(LeVeau, counter2, randomIndex);
                    if (counter2 + randomIndex < 24) {
                        counter2 += randomIndex;
                    } else {
                        counter2 = 24;
                    }
                    // Make the pony move backward
                } else if (Objects.equals(LeVeau[0], "<o")) {
                    LeVeau[0] = "<0";
                    break;
                } else if (Objects.equals(LeVeau[counter2], "<o")) {
                    LeVeauString = movePonyBack(LeVeau, counter2, randomIndex);
                    if (counter2 - randomIndex > 0) {
                        counter2 -= randomIndex;
                    } else {
                        counter2 = 0;
                    }
                }

                // THIRD PONY
                randomIndex = random.nextInt(4);
                // Make the pony move forward
                if (Objects.equals(Dubosc[counter3], "o>")) {
                    DuboscString = movePony(Dubosc, counter3, randomIndex);
                    if (counter3 + randomIndex < 24) {
                        counter3 += randomIndex;
                    } else {
                        counter3 = 24;
                    }
                    // Make the pony move backward
                } else if (Objects.equals(Dubosc[0], "<o")) {
                    Dubosc[0] = "<0";
                    break;
                } else if (Objects.equals(Dubosc[counter3], "<o")) {
                    DuboscString = movePonyBack(Dubosc, counter3, randomIndex);
                    if (counter3 - randomIndex > 0) {
                        counter3 -= randomIndex;
                    } else {
                        counter3 = 0;
                    }
                }
                // Display pool after the ponies moved
                displayPool(BousquetString, LeVeauString, DuboscString);
            }
        } while (!Objects.equals(Bousquet[0], "<o") || !Objects.equals(LeVeau[0], "<o") || !Objects.equals(Dubosc[0], "<o"));
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
        System.out.println("####################################################");
        System.out.println("#" + a + "#");
        System.out.println("#" + b + "#");
        System.out.println("#" + c + "#");
        System.out.println("####################################################");
    }
}