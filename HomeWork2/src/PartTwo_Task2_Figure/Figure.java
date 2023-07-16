package PartTwo_Task2_Figure;

public class Figure {
    private static int numberCountingAreas = 0;

    public static double formulaRightTriangle(double cathet1, double cathet2) { //Вычисление площади прямоугольного треугольника
        numberCountingAreas++;
        return (cathet1 * cathet2) / 2;
    }

    public static double formulaGerona(double side1, double side2, double side3) { //Формула Герона
        numberCountingAreas++;
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public static double SquareTriangle(double footing, double height) { //Основание на высоту
        numberCountingAreas++;
        return footing * height / 2;
    }

    public static double rectangleArea(double lengthA, double lengthB) { //Площадь прямоугольника
        numberCountingAreas++;
        return lengthA * lengthB;
    }

    public static double squareArea(double sideA) { //Прощадь квадрата
        numberCountingAreas++;
        return Math.pow(sideA, 2);
    }

    public static double squareRhombus(double side, double height) {
        numberCountingAreas++;
        return side * height;
    }

    public static int getNumberCountingAreas() {
        return numberCountingAreas;
    }


}
