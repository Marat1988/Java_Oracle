package PartTwo_Task7_Figure;

public class Trapezoid extends Figure_New { //Трапеция
    private double lowerBase; //Нижнее основание
    private double upperBase; //Верхнее основание
    private double height; //Высота

    public Trapezoid(double lowerBase, double upperBase, double height) {
        this.lowerBase = lowerBase;
        this.upperBase = upperBase;
        this.height = height;
    }

    @Override
    public double getArea() {
        return ((lowerBase + upperBase) / 2) * height;
    }
}
