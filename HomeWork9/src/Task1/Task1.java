package Task1;

import java.util.*;

public class Task1 {
    private static final int maxCountNumber = 10;
    private static final Long[] numbers = new Long[maxCountNumber];
    private static long sumNumber = 0;
    private static double averageNumber = 0;
    public static void main(String[] args) {
        Thread threadAddNumber = new Thread(() -> {
            for (int i = 0; i < maxCountNumber; i++) {
                numbers[i] = (long) ((Math.random() * 10) + 10);
            }
        });
        Thread threadSum = new Thread(() -> {
            try {
                threadAddNumber.join(); //Ждем, пока заполниться массив
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Optional<Long> sum = Arrays.stream(numbers)
                    .reduce(Long::sum);
            sum.ifPresent(aLong -> sumNumber = aLong);
        });
        Thread threadAvg = new Thread(() -> {
            try {
                threadAddNumber.join(); //Ждем, пока заполниться массив
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            OptionalDouble avg = Arrays.stream(numbers)
                    .mapToLong(numbers -> numbers)
                    .average();
            avg.ifPresent(aAvg -> averageNumber = aAvg);
        });
        threadAddNumber.start();
        threadSum.start();
        threadAvg.start();
        try {
            threadSum.join();
            threadAvg.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Элементы массива: ");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Сумма элементов массива равна: " + sumNumber);
        System.out.println("Среднее арифметическое эдементов массива равна: " + averageNumber);
    }
}
