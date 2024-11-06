package app;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");

            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (ch == 'c') {
                Product prd = new Product(name, price);
                list.add(prd);
                System.out.println();

            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufacturedDate = sdf.parse(sc.next());
                Product prd = new UsedProduct(name, price, manufacturedDate);
                list.add(prd);
                System.out.println();

            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                Product prd = new ImportedProduct(name, price, customsFee);
                list.add(prd);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();

    }
}
