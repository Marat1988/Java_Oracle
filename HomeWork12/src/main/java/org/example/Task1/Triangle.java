package org.example.Task1;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public double calcSquare() {
        double p = (sideA + sideB + sideC) / 2.0; //Полупериметр
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
