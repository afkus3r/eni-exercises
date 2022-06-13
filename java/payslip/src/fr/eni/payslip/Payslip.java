package fr.eni.payslip;

import java.util.Scanner;

public class Payslip {

    static float calculateBaseSalary(int nbHours, float hourlyRate) {
        int baseSalary = 0;
        for (int i = 0; i < nbHours; i++) {
            if (i < 169) {
                baseSalary += hourlyRate;
            } else if (i < 180) {
                baseSalary += hourlyRate * 1.5;
            } else {
                baseSalary += hourlyRate * 1.6;
            }
        }
        return baseSalary;
    }

    static float calculateContributions(float baseSalary) {
        float contributions = 0;
        System.out.println("Remboursement de la dette sociale : " + baseSalary * 0.0349);
        contributions += baseSalary * 0.0349;
        System.out.println("Contribution sociale généralisée : " + baseSalary * 0.0615);
        contributions += baseSalary * 0.0615;
        System.out.println("Assurance maladie : " + baseSalary * 0.0095);
        contributions += baseSalary * 0.0095;
        System.out.println("Assurance vieillesse : " + baseSalary * 0.0844);
        contributions += baseSalary * 0.0844;
        System.out.println("Assurance chômage : " + baseSalary * 0.0305);
        contributions += baseSalary * 0.0305;
        System.out.println("Retraite complémentaire : " + baseSalary * 0.0381);
        contributions += baseSalary * 0.0381;
        System.out.println("Cotisation AGFF : " + baseSalary * 0.0102);
        contributions += baseSalary * 0.0102;
        return contributions;
    }

    static int calculateBonus(int nbChildren) {
        int bonus = 0;
        if (nbChildren == 1) {
            bonus = 20;
        } else if (nbChildren == 2) {
            bonus = 50;
        } else if (nbChildren > 2) {
            bonus = 70 + (nbChildren - 2) * 20;
        }
        return bonus;
    }

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner floatInput = new Scanner(System.in);

        System.out.println("Veuillez entrer le nombre d'heures travaillées.");
        int nbHours = intInput.nextInt();

        System.out.println("Veuillez entrer votre salaire horaire.");
        float hourlyRate = floatInput.nextFloat();

        System.out.println("Veuillez entrer le nombre d'enfants à charge.");
        int nbChildren = intInput.nextInt();

        float baseSalary = calculateBaseSalary(nbHours, hourlyRate);
        System.out.println("Salaire mensuel de base : " + baseSalary);

        float contributions = calculateContributions(baseSalary);
        System.out.println("Cotisations sociales : " + contributions);

        int bonus = calculateBonus(nbChildren);
        System.out.println("Primes famille : " + bonus);

        System.out.println("Net à payer : " + ((baseSalary + bonus) - contributions));
    }
}
