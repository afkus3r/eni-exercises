package fr.eni.guestList;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GuestList {
    static String[] guests = {"Apolline", "Victoire", "Diane", "Aliénor", "Alexandre", "Jade"};

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        int userInput = 0;
        int guestChoice = 0;
        String nameInput = "";

        System.out.println("Bonjour, voici la liste actuelle des invités :");
        System.out.println(String.join(" ", guests));

        do {
            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Ajouter un invité");
            System.out.println("2 - Supprimer un invité");
            System.out.println("3 - Valider la liste");
            userInput = intInput.nextInt();

            if (userInput == 1) {
                System.out.println("Entrer le nom de la personne que vous souhaitez ajouter :");
                nameInput = stringInput.nextLine();
                guests = addGuest(nameInput);
                System.out.println("Voici la nouvelle liste :");
                System.out.println(String.join(" ", guests));
            } else if (userInput == 2) {
                System.out.println("Choisissez la personne que vous souhaitez supprimer :");
                for (int i = 0; i < 6; i++) {
                    System.out.println(i + " - " + guests[i]);
                }
                guestChoice = intInput.nextInt();
                guests = removeGuest(guestChoice);
                System.out.println("Voici la nouvelle liste :");
                System.out.println(String.join(" ", guests));
            } else if (userInput == 3) {
                System.out.println("Voici la liste finale des invités :");
                System.out.println(String.join(" ", guests));
                System.out.println("Bonne journée !");
            } else {
                System.out.println("Veuillez choisir un chiffre parmis la liste proposée.");
            }
        } while (userInput != 3);
    }

    static String[] removeGuest(int a) {
        guests[a] = "";
        return guests;
    }

    static String[] addGuest(String name) {
        for (int i = 0; i < 6; i++) {
            if (Objects.equals(guests[i], "")) {
                guests[i] = name;
            }
        }
        return guests;
    }
}