package MarkADom.S.C.U.M;


import java.util.Arrays;
import java.util.List;
import java.util.function.*;


public interface BiOperation {

    IntUnaryOperator unaryOperator = (num -> num * 100);

    Function<String, Integer> strLength = str -> str.length();

    Predicate<String> lengthGreaterThan5 = str -> str.length() > 5;

    BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + " is " + str2;

    Thread myThread = new Thread(() -> System.out.println("Hello world from another thread"));

    List<String> names = Arrays.asList("Ethan", "Nam", "Bob", "Alice");
    Consumer<List<String>> consumer = (list -> {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "Your name is: " + list.get(i));
            names.forEach(System.out::println);
        }
    });







}




