package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        //Logic to read archive or file on screen.
        File file = new File("D:\\code\\test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
