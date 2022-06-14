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
        
    }
}
