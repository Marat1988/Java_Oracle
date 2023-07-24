package Task3;

public class Task3 {
    public static void main(String[] args) {
        MyPredicate<Integer> myPredicateIntegerMax = (number1, number2, number3, number4) ->
                Math.max(Math.max(number1, number2), Math.max(number3, number4));
        MyPredicate<Double> myPredicateDoubleMax = (number1, number2, number3, number4) ->
                Math.max(Math.max(number1, number2), Math.max(number3, number4));
        System.out.println("Максимальное из чисел 3, 5, 7, 9 равно: " + myPredicateIntegerMax.test(3, 4, 5, 7));
        System.out.println("Максимальное из чисел 3.5, 5.5, 7.5, 9.89 равно: " + myPredicateDoubleMax.test(3.5, 5.5, 7.5, 9.89));
    }
}
