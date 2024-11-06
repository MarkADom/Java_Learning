package application;

import entities.Product;
import services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        /*
          Super flexible function that it takes not only the list but also
          which condition I'm going to want to use to filter my list.
        */
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'M');
        double sum2 = ps.filteredSum(list, p -> p.getPrice() < 100 );

        System.out.println("Sum: " + String.format("%.2f", sum));
        System.out.println("Sum2: " + String.format("%.2f", sum2));

    }
}
