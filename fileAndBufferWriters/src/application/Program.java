package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {


        //Allows to create files.

        String[] lines = new String[]{
                "Good morning", "Good afternoon", "Good night"
        };

        String path = "D:\\code\\test2.txt";

        //Using true allows to add ang not recreate the file
        //try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
