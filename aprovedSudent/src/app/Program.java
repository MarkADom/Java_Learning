package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        double avg;

        System.out.print("Students to add: ");
        n = sc.nextInt();

        String[] names = new String[n];
        double[] firsGrade = new double[n];
        double[] secondGrade = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Input name, first and second grade from the " + (i + 1) + " student:");
            sc.nextLine();
            names[i] = sc.nextLine();
            firsGrade[i] = sc.nextDouble();
            secondGrade[i] = sc.nextDouble();
        }

        System.out.println("Students aproved: ");
        for (int i = 0; i < n; i++) {
            avg = (firsGrade[i] + secondGrade[i]) / 2;
            if (avg >= 6){
                System.out.println(names[i]);
            }

        }

        sc.close();

    }
}
