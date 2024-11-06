package app;

import entities.Rent;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Rent[] vect = new Rent[10];

        System.out.print("How many rooms will be rented: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Rent #" + i + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Room: ");
            int roomNumber = sc.nextInt();

            /**
             * The code above is to simplify
             * Rent rent = new Rent(name, email);
             * arr[room] = rent;
             */

            vect[roomNumber] = new Rent(name, email);

        }
        System.out.println();
        System.out.println("Busy room:");
        for (int i = 0; i < 10; i++) {
            if (vect[i] != null) {
                System.out.println(i + ": " + vect[i]);
            }
        }
        sc.close();
    }
}
