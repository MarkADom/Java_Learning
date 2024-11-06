package app;

import java.util.Scanner;

public class ArrayTwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[Matrix Size]");
        System.out.print("Line lumber: ");
        int line = sc.nextInt();
        System.out.print("Row lumber: ");
        int row = sc.nextInt();

        int[][] matrix = new int[line][row];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                sc.nextLine();
                matrix[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length;  j++) {
                if(matrix[i][j] == x){
                    System.out.println("Position " + i + ", " + j + ": ");
                    if (j > 0) {
                        System.out.println("Left: " + matrix[i][j-1]);
                    }
                    if (i>0){
                        System.out.println("Up: " + matrix[i-1][j]);
                    }
                    if (j<matrix[i].length-1){
                        System.out.println("Right: " + matrix[i][j+1]);
                    }
                    if (i < matrix.length - 1) {
                        System.out.println("Down: " + matrix[i+1][j]);
                    }
                }
            }

        }

        sc.close();

    }
}
