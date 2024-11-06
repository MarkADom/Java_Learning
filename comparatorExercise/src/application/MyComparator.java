package application;

import entities.Product;
import java.util.Comparator;

/*
  Functional Interface has a direct mapping with the lambda expression.
  Lambda expression will be treated as an interface, in this case a functional interface.
*/

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
}
