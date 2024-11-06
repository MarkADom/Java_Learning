package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        //Importing file

        File file = new File("D:\\code\\test.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        //Catch the exception if the file don't exist
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());

        //We need to close the scanner to avoid the file stay open.
        } finally {
            if (sc != null) {
                sc.close();
            }

            //The block finally always executes
            System.out.println("Finally block executed");
        }
    }
}