package PartTwo_Task7_Figure;

public class Circle extends Figure_New { //Круг
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
