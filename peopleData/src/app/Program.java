package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        double minHeight;
        double maxHeight;
        double avgFemaleH;
        double avgMaleH;
        double totalFHeight;
        double totalMHeight;
        double manNum;
        double womanNum;

        System.out.print("How many people to add: ");
        n = sc.nextInt();

        char[] genders = new char[n];
        double[] heights = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Person nº" + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
            System.out.print("Person nº" + (i + 1) + " gender: ");
            genders[i] = sc.next().charAt(0);
        }

        minHeight = heights[0];
        maxHeight = heights[0];

        for (int i = 0; i < n; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            }
            if (heights[i] < minHeight) {
                minHeight = heights[i];
            }
        }

        manNum = 0;
        womanNum = 0;
        totalMHeight = 0;
        totalFHeight = 0;

        for (int i = 0; i < n; i++) {
            if (genders[i] == 'M') {
                manNum++;
                totalMHeight = totalMHeight + heights[i];
            } else {
                womanNum++;
                totalFHeight = totalFHeight + heights[i];
            }
        }

        avgFemaleH = totalFHeight / womanNum;
        avgMaleH = totalMHeight / manNum;


        System.out.printf("Minimum height: %.2f%n", minHeight);
        System.out.printf("Max height: %.2f%n", maxHeight);
        System.out.printf("Woman average height: %.2f%n", avgFemaleH);
        System.out.printf("Man average height: %.2f%n", avgMaleH);
        System.out.printf("Man number: %.0f%n", manNum);
        System.out.printf("Woman number: %.0f%n", womanNum);

        sc.close();
    }
}
