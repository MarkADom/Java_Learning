package application;

import entities.Product;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {


        //Creating a list of integers.
        List<Product> list = new ArrayList<>();

        //Defining here the path of a file.
        String path = "D:\\code\\Udemy\\in2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Opening the file and reading all the lines in the file,
            //saving it in the list of integers each number contained in that file.
            String line = br.readLine();
            while (line != null) {
                //Array receiving line from file and using "split" to split every element.
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            Product x = CalculationService.max(list);
            System.out.println("Higher Price: ");
            System.out.println(x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
