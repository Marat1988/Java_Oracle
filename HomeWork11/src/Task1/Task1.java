package Task1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task1 {
    private static final int countNumber = 50;
    private static final int beginRange = -500;
    private static final int endRange = 500;
    private static long[] array = new long[countNumber];

    public static void main(String[] args) {
        array = IntStream.range(0, array.length)
                .mapToLong(num -> (int) (Math.random() * (endRange - beginRange)) + beginRange)
                .toArray();
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(array));
        System.out.println("=============================================================================");
        System.out.println("Количество положительных чисел: " + Arrays.stream(array)
                .filter(num -> num >= 0)
                .count());
        System.out.println("Количество отрицательных чисел: " + Arrays.stream(array)
                .filter(num -> num < 0)
                .count());
        System.out.println("Количество двухзначных чисел: " + Arrays.stream(array)
                .filter(num -> Math.abs(num) >= 10 && Math.abs(num) <= 99)
                .count());
        System.out.println("Количество зеркальных чисел: " + Arrays.stream(array)
                .filter(num -> Math.abs(num) > 10 && reverseNumber(Math.abs(num)) == num)
                .count());
        System.out.println("=============================================================================");
    }

    private static long reverseNumber(long num) {
        long reverse = 0;
        while (num != 0) {
            reverse = reverse * 10;
            reverse = reverse + num % 10;
            num = num / 10;
        }
        return reverse;
    }
}
