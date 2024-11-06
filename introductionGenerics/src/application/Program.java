package application;

import services.PrintService;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Instantiation of a PrintService, here i can choose de type.
        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer value =sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        //We don't need to use de cast because the Type Safe grants if you call the method first he will return an integer.
        Integer x = ps.first();
        System.out.print("First: " + x);

        sc.close();

    }
}
