package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        System.out.println("Total Area: " + String.format("%.2f", totalArea(myShapes)));
    }

    /**
     * Method receiving the list Shape and going through the list,accumulating
     * of areas of each element on the list and at the end it returns sum.
     * Adding "? extends" allows to receive the Shape list and even be a list of
     * a Shape subtype.
     **/
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}
