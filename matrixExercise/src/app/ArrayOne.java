package app;

import java.util.Scanner;

public class ArrayOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Matrix size: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Row #"  + i + ": ");
                sc.nextLine();
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("Main diagonal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(mat[i][i] + " ");
        }

        System.out.println();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < 0) {
                    count++;
                }
            }
        }

        System.out.println("Negative number: " + count);

        sc.close();

    }
}
