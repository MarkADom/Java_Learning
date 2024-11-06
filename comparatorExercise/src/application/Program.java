package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));


        /*
        To this work we need to implement the Interface Comparator
        with the type we want
        */
        list.sort(new MyComparator());
        /*
        Creating an anonymous class Substitute the implementation of the Interface Comparator
        */
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        };
        /*
        Creating an anonymous function,  arrow function : comp = receiving to arguments,
        and the function implementation comes after
*/
        Comparator<Product> comp2 = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());


        //To avoid call the Comparator above we call as argument of sort the lambda expression.
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }

        /*
        Separate class object Comparator
        Comparator Anonymous Class Object
        Comparator lambda expression object with curly brackets
        Comparator lambda expression object without curly braces
        Comparator lambda expression "straight in the argument"
        */
    }
}

