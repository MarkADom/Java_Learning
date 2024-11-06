package application;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        int num, a = 0, b = 0, c = 1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of times: ");
        num = sc.nextInt();
        System.out.println("Fibonacci Series of the number is: ");

        for (int i = 0; i < num; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.println(a + "");
        }

        sc.close();

        Stream<Long> st4 = Stream.iterate(new long[]{0L, 1L}, p-> new long[]{p[1],p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

    }
}
