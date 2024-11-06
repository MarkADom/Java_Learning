package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many new entries: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] ages = new int[n];
        double[] heights = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Person nº" + (i + 1) + " data:");
            System.out.println();
            System.out.print("Name: ");
            names[i] = sc.next();
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
            System.out.print("Height: ");
            heights[i] = sc.nextDouble();
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + heights[i];
        }

        double avg = sum / n;

        System.out.println();
        System.out.printf("The Average Height: %.2f%n", avg);

        int count = 0;
        System.out.println();
        System.out.println("Calculating average age.");
        System.out.print("Insert Age Limit: ");
        int ageLimit = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (ages[i] < ageLimit) {
                count = count + 1;
            }
        }

        double percentage = (count * 100.0) / n;
        System.out.printf("Percentage: %.2f%%%n", percentage);

        for (int i = 0; i < n; i++) {
            if (ages[i] < ageLimit) {
                System.out.println(names[i]);
            }
        }

        sc.close();

    }

}

