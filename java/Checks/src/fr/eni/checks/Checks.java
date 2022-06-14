package fr.eni.checks;

import java.util.Scanner;

public class Checks {
    public static void main(String[] args) {
        // Calculation variables declarations
        int nbChecks = 0;
        float sumChecks;
        float averageChecks;
        int nbChecksHigher200 = 0;
        int nbChecksLower200 = 0;
        float sumChecksHigher200 = 0;
        float sumChecksLower200 = 0;
        int smallerCheck = 0;
        int biggerCheck = 0;
        float sumSmallerCheck = 0;
        float sumBiggerCheck = 0;

        // User input variables declarations
        Scanner intInput = new Scanner(System.in);
        Scanner floatInput = new Scanner(System.in);
        int checkNumber;
        float checkAmount = 0;

        do {
            // Get user input for check number and amount
            System.out.println("Entrez le numéro de votre chèque, ou 0 si vous n'en avez plus.");
            checkNumber = intInput.nextInt();
            if (checkNumber != 0) {
                System.out.println("Entrez le montant du chèque.");
                checkAmount = floatInput.nextFloat();
                nbChecks++;
            }

            // Sort out the bigger and smaller checks
            if (checkNumber != 0 && (checkAmount < sumSmallerCheck || smallerCheck == 0)) {
                smallerCheck = checkNumber;
                sumSmallerCheck = checkAmount;
            }
            if (checkNumber != 0 && checkAmount > sumBiggerCheck) {
                biggerCheck = checkNumber;
                sumBiggerCheck = checkAmount;
            }

            // Sort checks higher or lower than 200
            if (checkNumber != 0 && checkAmount < 200) {
                nbChecksLower200++;
                sumChecksLower200 += checkAmount;
            } else if (checkNumber != 0 && checkAmount >= 200) {
                nbChecksHigher200++;
                sumChecksHigher200 += checkAmount;
            }

        } while (checkNumber != 0);

        // Calculate sums and averages
        sumChecks = sumChecksLower200 + sumChecksHigher200;
        averageChecks = sumChecks / nbChecks;

        // Results display
        System.out.println("Vous avez entrés " + nbChecks + " chèques pour un montant total de " + sumChecks + " et une moyenne de " + averageChecks + ".");
        System.out.println("Dont " + nbChecksLower200 + " chèque inférieurs à 200€ pour un total de " + sumChecksLower200 + ".");
        System.out.println("Et " + nbChecksHigher200 + " chèques supérieurs à 200€ pour un total de " + sumChecksHigher200 + ".");
        System.out.println("Le chèque n°" + smallerCheck + " est le plus petit avec un montant de " + sumSmallerCheck + ".");
        System.out.println("Le chèque n°" + biggerCheck + " est le plus grand avec un montant de " + sumBiggerCheck + ".");
    }
}
