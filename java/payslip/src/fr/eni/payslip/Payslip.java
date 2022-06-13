package fr.eni.payslip;

public class Payslip {
    int baseSalary;

    public int calculateBaseSalary (int nbHours, int hourlyRate) {
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

    public static void main(String[] args) {

    }
}
