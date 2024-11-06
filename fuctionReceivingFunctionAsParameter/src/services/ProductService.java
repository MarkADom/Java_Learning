package services;

import entities.Product;
import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    //Here a generic test of any predicate received as a parameter.
    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum = 0.0;
        for (Product p : list){
            if(criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
