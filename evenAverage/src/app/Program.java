package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int evenSum = 0;
        int evenNum = 0;
        double evenAvr;

        System.out.print("Input vector number: ");
        n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Input number: ");
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (num[i] % 2 == 0){
                evenSum = evenSum + num[i];
                evenNum++;
            }
        }

        if(evenNum == 0) {
            System.out.println("No Even Found!");
        } else {
            evenAvr = (double) evenSum / evenNum;
            System.out.printf("Even Average: %.1f%n",evenAvr);
        }

        sc.close();
    }
}
