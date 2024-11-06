package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int older;
        int posOlder;

        System.out.print("Enter the people to Add: ");
        n = sc.nextInt();

        String[] names = new String[n];
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Person nº" + (i + 1) + " data:");
            System.out.print("Name: ");
            names[i] = sc.next();
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
        }

        older = ages[0];
        posOlder = 0;

        for (int i = 0; i < n; i++) {
            if (ages[i] > older){
                older = ages[i];
                posOlder = i;
            }
        }

        System.out.println("The oldest person is: " +  names[posOlder]);

        sc.close();
    }
}
