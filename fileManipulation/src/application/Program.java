package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter folder path: ");
        String strPath = sc.nextLine();

        //File class can be the path to a folder or a file
        File path = new File(strPath);

        //Create an Array of the folders paths
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("Folders:");
        for (File folder : folders) {
            System.out.println(folder);
        }
        //Create an Array of the file paths
        File[] files = path.listFiles(File::isFile);
        System.out.println("Files:");
        for (File file : files) {
            System.out.println(file);
        }

        //Create a folder on the path choose
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);

        sc.close();
    }
}
