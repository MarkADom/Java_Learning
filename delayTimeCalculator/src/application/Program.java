package application;

import entities.MainFrame;
import entities.NoteLength;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();


        Scanner sc = new Scanner(System.in);
        System.out.print("Tempo: ");
        double tempo = sc.nextDouble();
        sc.nextLine();

        ArrayList<NoteLength> list = new ArrayList<>();

        list.add(new NoteLength("8", 32.00));
        list.add(new NoteLength("4", 16.00));
        list.add(new NoteLength("3", 12.00));
        list.add(new NoteLength("2", 8.0));
        list.add(new NoteLength("3/2", 6.0));
        list.add(new NoteLength("1", 4.0));
        list.add(new NoteLength("3/4", 3.0));
        list.add(new NoteLength("1/2", 2.0));
        list.add(new NoteLength("1/4", 1.0));
        list.add(new NoteLength("1/8", 0.5));
        list.add(new NoteLength("1/16", 0.25));
        list.add(new NoteLength("1/32", 0.125));
        list.add(new NoteLength("1/64", 0.0625));
        list.add(new NoteLength("1/128", 0.03125));


        double freq = tempo / 60.00;
        System.out.println("Frequency: " + String.format("%.3f", freq) + " Hz");
        double measure = ((60.00 / tempo) * 1000) * 4;
        System.out.println("Measure(4/4): " + String.format("%.2f", measure) + " ms");
        System.out.println();
        System.out.println("NL ; Normal ; Dotted ; Triplet ");

        for (NoteLength note : list) {
            System.out.println(note.getLength()
                    + " ; "
                    + String.format("%.3f", (60000 / tempo) * note.getValue())
                    + " ; "
                    + String.format("%.3f", (60000 / tempo) * (note.getValue() + (note.getValue() * 1 / 2)))
                    + " ; "
                    + String.format("%.3f", (60000 / tempo) * (note.getValue() * 2 / 3))
            );
        }
    }
}


