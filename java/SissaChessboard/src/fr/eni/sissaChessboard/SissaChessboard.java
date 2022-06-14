package fr.eni.sissaChessboard;

public class SissaChessboard {
    public static void main(String[] args) {
        float rice = 1;
        float totalRice = 1;
        for (int i = 1; i < 64; i++) {
            rice *= 2;
            totalRice += rice;
        }

        System.out.println("Il y'a " + totalRice + " grains de riz sur l'échiquier de Sissa.");
    }
}