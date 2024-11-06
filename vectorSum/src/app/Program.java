package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many number by vector:");
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        System.out.println("Input vector A values: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Input vector B values: ");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }

        System.out.println("Vector Sum: ");
        for (int i = 0; i < n; i++) {
            System.out.println(c[i]);
        }

        sc.close();
    }
}
