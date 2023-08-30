package org.example.Task4;

public class Number {
    private int value;

    public Number() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toBinary() {
        return Integer.toString(value, 2);
    }

    public String toOctal() {
        return Integer.toString(value, 8);
    }

    public String toHex() {
        return Integer.toString(value, 16);
    }
}
