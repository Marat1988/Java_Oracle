package PartTwo_Task3_Calc;

public class Calc {

    public static int maxFourArguments(int number1, int number2, int number3, int number4) { //Максимальное четырех чисел
        return Math.max(Math.max(number1, number2), Math.max(number3, number4));
    }

    public static int minFourArguments(int number1, int number2, int number3, int number4) { //Минимальное четырех чисел
        return Math.min(Math.min(number1, number2), Math.min(number3, number4));
    }

    public static double avgFourArguments(int number1, int number2, int number3, int number4) { //Среднее арифметическое четырех чисел
        return (number1 + number2 + number3 + number4) / 4.0;
    }

    public static double Factorial(int number) { //Факториал аргумента
        if (number == 0) {
            return 1;
        } else {
            return number * Factorial(number - 1);
        }
    }
}
