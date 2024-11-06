package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double max;
        int pos;
        System.out.print("How many number: ");
        int n = sc.nextInt();

        double[] numbers = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input Number: ");
            numbers[i] = sc.nextDouble();
        }

        max = numbers[0];
        pos = 0;

        for (int i = 0; i < n; i++) {
            if(numbers[i] > max){
                max = numbers[i];
                pos = i;
            }
        }

        System.out.println("Max Value Number: " + max);
        System.out.println("Max Number Position: " + pos);

        sc.close();
    }
}
