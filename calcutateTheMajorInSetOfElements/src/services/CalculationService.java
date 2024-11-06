package services;

import java.util.List;

public class CalculationService{

    //Receive a List of Integers
        //It will work with any type T as long as the T is any subtype of comparable T.
    public static <T extends Comparable<T>> T max(List<T> list) {
        //Defensive programming  checking if the list it's empty.
        if (list.isEmpty()) {
            throw new IllegalStateException("List can´t be empty");
        }
        //List not being empty we start to find the largest element of a list.
        //Creating a variable to receive the list first element.
        T max = list.get(0);

        //Comparing if each item in this list is greater than the Max.
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                //If this is greater than zero it means the first is greater than the second.
                //So in this case update the Max variable.
                max = item;
            }
        }
        return max;
    }
}
