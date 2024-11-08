package application;

import entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Set<Product> set = new HashSet<>();

        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));

        Product prod = new Product("Notebook", 1200.0);

        /* To get a true output about the elements and not the references
          we need to instantiate equals() and hashCode on Product class. */
        System.out.println(set.contains(prod));

    }
}
