package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("maria");
        list.add("bob");
        list.add("alex");
        list.add("rita");
        list.add("marco");
        list.add("alberto");
        list.add(2, "Jane");

        System.out.println(list.size());

        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("----------------");

        list.remove("rita");
        list.removeIf(x -> x.charAt(0) == 'm');
        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("----------------");
        System.out.println("Index Of bob: " + list.indexOf("bob"));

        System.out.println("----------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'a').collect(Collectors.toList());
        for (String x : result) {
            System.out.println(x);
        }

        System.out.println("----------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'a').findFirst().orElse(null);
        System.out.println(name);

    }
}
