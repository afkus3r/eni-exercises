import java.util.Scanner;

public class MaxValue {
    static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    static int sort(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        System.out.println("Entrez un premier nombre :");
        int firstNum = intInput.nextInt();
        System.out.println("Entrez un second nombre :");
        int secondNum = intInput.nextInt();

        System.out.println("Le plus grand nombre des deux est " + findMax(firstNum, secondNum));
        System.out.println("0 s'ils sont égaux, 1 si le premier est plus grand que le second, sinon -1 : " + sort(firstNum, secondNum));

    }
}
