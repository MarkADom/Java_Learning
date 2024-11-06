package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        method1();
        System.out.println("End of program");
    }

    public static void method1() {
        System.out.println("*** METHOD1 START ***");
        method2();
        System.out.println("*** METHOD1 END ***");
    }

    public static void method2() {

        System.out.println("*** METHOD2 START ***");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input: ");

            //Create an array of strings creating position by space
            String[] vect = sc.nextLine().split(" ");
            System.out.print("Output nº: ");
            int pos = sc.nextInt();
            System.out.println(vect[pos]);

            //Exception for values out of limit
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Position!");

            /** Prints on screen stack trace
             * e.printStackTrace();
            **/

            //Exception for wrong type of value input
        } catch (InputMismatchException e) {
            System.out.println("Input error!");
        }

        sc.close();
        System.out.println("*** METHOD2 END ***");
    }


}

