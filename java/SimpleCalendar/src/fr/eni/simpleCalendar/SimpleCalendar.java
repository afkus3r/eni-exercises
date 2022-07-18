package fr.eni.simpleCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Scanner;

public class SimpleCalendar {
    public static void main (String[] args) {
        Scanner stringInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);

        // Display current month calendar
        System.out.println("Hello, here is the current month calendar :");
        GregorianCalendar currentCal = new GregorianCalendar();
        displayCalendar(currentCal.get(Calendar.MONTH), currentCal.get(Calendar.YEAR));

        System.out.println("Press enter to chose another month");
        String enter = stringInput.nextLine();
        while (Objects.equals(enter, "")) {
            System.out.println("Enter the number of the month you want");
            int monthNum = intInput.nextInt();
            System.out.println("Enter the year of your choice");
            int year = intInput.nextInt();
            displayCalendar(monthNum - 1, year);
            System.out.println("Press enter to chose another month or press Q to quit");
            enter = stringInput.nextLine();
        }
        if (Objects.equals(enter, "Q")) {
            System.out.println("Goodbye !");

        }

    }
    public static void displayCalendar(int month, int year) {
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);

        String monthName = "Month";
        switch (month) {
            case 0 -> monthName = "January";
            case 1 -> monthName = "February";
            case 2 -> monthName = "March";
            case 3 -> monthName = "April";
            case 4 -> monthName = "May";
            case 5 -> monthName = "June";
            case 6 -> monthName = "July";
            case 7 -> monthName = "August";
            case 8 -> monthName = "September";
            case 9 -> monthName = "October";
            case 10 -> monthName = "November";
            case 11 -> monthName = "December";
        }

        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        switch (firstDay) {
            case 2 -> firstDay = 1;
            case 3 -> firstDay = 2;
            case 4 -> firstDay = 3;
            case 5 -> firstDay = 4;
            case 6 -> firstDay = 5;
            case 7 -> firstDay = 6;
            case 1 -> firstDay = 7;
        }

        // Initialize first row with days names
        String[][] matrix = new String[7][7];
        matrix[0][0] = "Mo";
        matrix[0][1] = "Tu";
        matrix[0][2] = "We";
        matrix[0][3] = "Th";
        matrix[0][4] = "Fr";
        matrix[0][5] = "Sa";
        matrix[0][6] = "Su";

        // Initialize second row
        for (int i = 0; i < firstDay-1; i++) {
            matrix[1][i] = "  ";
        }

        for (int i = 1; i < 7 - firstDay + 2; i++) {
            matrix[1][i + firstDay-2] = String.valueOf(i);
        }

        // Initialize all other matrix elements
        int lastDay = cal.getActualMaximum(Calendar.DATE);

        int holder = Integer.parseInt(matrix[1][6]) + 1;
        for (int i = 2; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (holder <= lastDay) {
                    matrix[i][j] = String.valueOf(holder);
                    holder++;
                }
            }
        }

        // Display calendar
        System.out.println(" * " + monthName + " " + year + " * ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
