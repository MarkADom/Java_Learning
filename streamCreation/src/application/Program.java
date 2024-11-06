package application;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);

        //Converting stream to vector with Arrays.toString(st1.toArray())
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("maiara", "alefd", "sada");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        //Fibonacci sequence

        Stream<Long> st4 = Stream.iterate(new long[]{0L, 1L},p-> new long[]{p[1],p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));

    }
}
