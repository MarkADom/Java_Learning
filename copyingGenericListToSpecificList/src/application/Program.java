package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        prinList(myObjs);
        copy(myDoubles, myObjs);
        prinList(myObjs);
    }
    /*The first list is the origin list and the second the destiny list
      This is a case of covariance. Working with subtypes allows the access
      to the elements and the target list. The target list is a case of counter
      variance. She works with super types of the informed type.
     */
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void prinList(List<?> list) {
        for(Object obj : list) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }
}

