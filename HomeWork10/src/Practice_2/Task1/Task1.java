package Practice_2.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private static final List<Integer> array = new ArrayList<>();
    private static int max = 0;
    private static int min = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите элемент массива или введите стоп для выхода: ");
        String inputUser = scanner.next();

        while (!inputUser.equals("стоп")) {
            array.add(Integer.parseInt(inputUser));
            System.out.print("Введите элемент массива или введите стоп для выхода: ");
            inputUser = scanner.next();
        }

        Thread threadMin = new Thread(() -> min = Collections.min(array));
        Thread threadMax = new Thread(() -> max = Collections.max(array));
        threadMax.start();
        threadMin.start();
        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Максимальный эдемент в массиве: " + max);
        System.out.println("Минимальный эдемент в массиве: " + min);
    }
}
