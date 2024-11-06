package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            List<String> emails = list.stream()
                    .filter(x -> x.getSalary() > salary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();

            System.out.println("Email of people whose salary is more than :"
                    + String.format("%.2f", salary));

            emails.forEach(System.out::println);

            System.out.println("List People by Word Sum:");
            System.out.print("Enter a letter: ");
            char firstWord = sc.next().charAt(0);

            double sum = list.stream()
                    .filter(x -> x.getName().charAt(0) == firstWord)
                    .map(x -> x.getSalary())
                    .reduce(0.0, (x, y) -> x + y);


            System.out.println("Sum salary from people whose name start with "
                    + firstWord
                    + ": "
                    + String.format("%.2f",sum));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}