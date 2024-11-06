package entities;

import entities.enums.Color;

public class Rectangle extends Shape {

    private Double with;
    private Double height;

    public Rectangle(){
        super();
    }

    public Rectangle(Color color, Double with, Double height) {
        super(color);
        this.with = with;
        this.height = height;
    }

    public Double getWith() {
        return with;
    }

    public void setWith(Double with) {
        this.with = with;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return with * height;
    }
}
