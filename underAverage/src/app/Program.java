package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many number: ");
        int n = sc.nextInt();

        double[] num = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Input number: ");
            num[i] = sc.nextDouble();
        }
         double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }

        double avr = sum / n;

        System.out.println();
        System.out.printf("Vector Average: %.2f%n",avr);

        System.out.println();
        System.out.println("Number under average: ");
        for (int i = 0; i < n; i++) {
            if(num[i] < avr){
                System.out.println(num[i]);
            }
        }

        sc.close();

    }
}
