package PartTwo_Task7_Figure;

public class RightTriangle extends Figure_New {

    private double cathet1;
    private double cathet2;

    public RightTriangle(double cathet1, double cathet2) {
        this.cathet1 = cathet1;
        this.cathet2 = cathet2;
    }

    @Override
    public double getArea() {
        return (cathet1 * cathet2) / 2;
    }
}
