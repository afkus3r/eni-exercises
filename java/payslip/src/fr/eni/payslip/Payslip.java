package fr.eni.payslip;

public class Payslip {
    public int calculateBaseSalary (int nbHours, int hourlyRate) {
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

    public float calculateContributions (int baseSalary) {
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

    public int calculateBonus (int nbChildren) {
        int bonus = 0;
    }

    public static void main(String[] args) {

    }
}
