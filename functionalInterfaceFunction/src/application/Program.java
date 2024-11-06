package application;

import entities.Product;
import util.UpperCaseName;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        /*
           Calling a .stream to obtain a stream form the list,
           after that calling function map, who applies a function
           to each element of the stream generating a new stream with
           the new transformed elements.Then converting all the elements
           to a new list collect(Collectors.toList().
         */

        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        names.forEach(System.out::println);


        //Static Method Instantiation
        list.forEach(Product::staticUpperCaseName);

        //NonStatic Method Instantiation
        list.forEach(Product::nonStaticUpperCaseName);

        //Declared Lambda Expression

        Function<Product, String> func = p -> p.getName().toUpperCase();
        List<String> names2 = list.stream().map(func).collect(Collectors.toList());


        //Inline Lambda Expression

        List<String> names3 = list.stream().map(func).collect(Collectors.toList());

        names.forEach(System.out::println);

    }
}
