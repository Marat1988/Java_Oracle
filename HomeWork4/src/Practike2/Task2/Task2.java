package Practike2.Task2;

public class Task2 {
    public static void main(String[] args) {
        ComparisonNumber max = Math::max;
        System.out.println(max.comparison(5, 8));

        ComparisonNumber min = Math::min;
        System.out.println(min.comparison(5, 8));

        FactorialNumber factorialNumber = number -> {
            int userNumber = 1;
            for (int i = 1; i <= number; i++) {
                userNumber *= i;
            }
            return userNumber;
        };
        System.out.println(factorialNumber.Factorial(5));

        PrimeNumber primeNumber = number -> {
            int count = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count > 1) {
                return false;
            } else {
                return true;
            }
        };
        System.out.println(primeNumber.isPrimeNumber(6));


    }
}
