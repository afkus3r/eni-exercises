package fr.eni.primeNumbers;

import java.util.Scanner;

public class PrimeNumbers {
    static void testPrimeNumber(int num) {
        boolean flag = false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        System.out.println("Entrez un nombre jusqu'auquel vous voulez tester les nombres entiers.");
        int numberInput = intInput.nextInt();

        System.out.println("Voici les nombres premier jusqu'à " + numberInput + " :");
        for (int i = 2; i < numberInput; i++) {
            testPrimeNumber(i);
        }
    }
}
