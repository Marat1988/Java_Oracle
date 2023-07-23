package Practice2.Task2;

public class Task2 {
    public static void main(String[] args) {
        ComparisonNumber max = Math::max;
        System.out.println("Максимальное из двух числе 5 и 8: " + max.comparison(5, 8));

        ComparisonNumber min = Math::min;
        System.out.println("Минимальное их двух чисел 5 и 8: " + min.comparison(5, 8));

        FactorialNumber factorialNumber = number -> {
            int userNumber = 1;
            for (int i = 1; i <= number; i++) {
                userNumber *= i;
            }
            return userNumber;
        };
        System.out.println("Факториал числа 5 равно: " + factorialNumber.Factorial(5));

        PrimeNumber primeNumber = number -> {
            int count = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            return count <= 1;
        };
        System.out.println("Число 5 простое (true) или нет (false): "+ primeNumber.isPrimeNumber(5));



    }
}
