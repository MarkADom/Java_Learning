package application;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        /**
         * Set<T>
         * HashSet: fast, operation O(1), without order.
         * TreeSet: slow, operation O(log(n)) on tree arrangement,ordered.
         * LinkedHashSet: intermediate, elements in the order they are added
         */


        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //Union: adds elements from the other set to the set, without repetition.
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //Intersection: removes from the set elements not contained in other.
        Set<Integer> d = new TreeSet<>(a);
        c.removeAll(b);
        System.out.println(d);

        //Difference: removes from the set the elements contained in other.
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }
}
