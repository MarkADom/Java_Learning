package app;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or Company (i/c)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double income = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, income, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, income, numberOfEmployees));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer tp : list) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": € " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("Total TAXES: € " + String.format("%.2f", sum));

        sc.close();
    }
}

