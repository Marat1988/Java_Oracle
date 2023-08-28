package org.example.Task1;

public class Square {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public int calcSquare() {
        return side * side;
    }
}
