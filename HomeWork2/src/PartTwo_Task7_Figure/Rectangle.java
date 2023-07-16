package PartTwo_Task7_Figure;

public class Rectangle extends Figure_New { //Прямоугольник

    private double length;
    private double height;

    public Rectangle(int length, int height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double getArea() {
        return length * height;
    }
}
