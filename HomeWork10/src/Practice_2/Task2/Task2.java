package Practice_2.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static final List<Integer> array = new ArrayList<>();
    private static int sum = 0;
    private static double average = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элемент массива или введите стоп для выхода: ");
        String inputUser = scanner.next();
        while (!inputUser.equals("стоп")) {
            array.add(Integer.parseInt(inputUser));
            System.out.print("Введите элемент массива или введите стоп для выхода: ");
            inputUser = scanner.next();
        }

        Thread threadSum = new Thread(() -> sum = array.stream()
                .reduce(Integer::sum).get().intValue());

        Thread threadAverage = new Thread(() -> average = (double) (array.stream()
                .reduce(Integer::sum).get().intValue()) / array.size());

        threadSum.start();
        threadAverage.start();

        try {
            threadSum.join();
            threadAverage.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);

    }
}
