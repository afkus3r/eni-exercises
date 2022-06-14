package fr.eni.cookingtime;

import java.util.Scanner;

public class CookingTime {
    public static void main(String[] args) {
        Scanner stringInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);

        System.out.println("Quelle viande voulez-vous cuisiner, boeuf ou porc ?");
        String meat = stringInput.nextLine();

        System.out.println("Combien pèse votre viande en grammes ?");
        int weight = intInput.nextInt();

        System.out.println("Quelle cuisson voulez-vous, bleue, à point ou bien cuite ?");
        String cooking = stringInput.nextLine();

        if (meat.equals("boeuf")) {
            switch (cooking) {
                case "bleue":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.02 + " minutes.");
                    break;
                case "à point":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.034 + " minutes.");
                    break;
                case "bien cuite":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.05 + " minutes.");
                    break;
                default:
                    System.out.println("Veuilliez choisir une cuisson valide.");
            }
        } else if (meat.equals("porc")) {
            switch (cooking) {
                case "bleue":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.0375 + " minutes.");
                    break;
                case "à point":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.0625 + " minutes.");
                    break;
                case "bien cuite":
                    System.out.println("Vous devez cuire votre viande " + weight * 0.1 + " minutes.");
                    break;
                default:
                    System.out.println("Veuilliez choisir une cuisson valide.");
            }
        } else {
            System.out.println("Nous ne savons pas cuisiner cette viande.");
        }
    }
}
