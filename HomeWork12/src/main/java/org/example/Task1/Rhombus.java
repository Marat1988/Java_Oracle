package org.example.Task1;

public class Rhombus {

    private int diagonal_1;
    private int diagonal_2;

    public Rhombus(int diagonal_1, int diagonal_2) {
        this.diagonal_1 = diagonal_1;
        this.diagonal_2 = diagonal_2;
    }

    public int getDiagonal_1() {
        return diagonal_1;
    }

    public int getDiagonal_2() {
        return diagonal_2;
    }

    public double calcSquare() {
        return (diagonal_1 * diagonal_2) / 2.0;
    }
}
