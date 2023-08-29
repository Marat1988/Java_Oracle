package org.example.Task2;

public class Calc {
    public long plus(long num_1, long num_2) {
        return num_1 + num_2;
    }

    public long minus(long num_1, long num_2) {
        return num_1 - num_2;
    }

    public long multiplication(long num_1, long num_2) {
        return num_1 * num_2;
    }

    public double division(double num_1, double num_2) {
        return num_1 / num_2;
    }

    public int maxNumbers(int num_1, int num_2) {
        return Math.max(num_1, num_2);
    }

    public int minNumbers(int num_1, int num_2) {
        return Math.min(num_1, num_2);
    }

    public double percentNumber(int number, double percent) {
        return (number * percent) / 100;
    }

    public double pow(int number, int pow) {
        return Math.pow(number, pow);
    }
}
