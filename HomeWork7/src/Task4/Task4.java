package Task4;

import java.util.Arrays;
import java.util.function.Predicate;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {-1, -5, 5, 5, 4, 8, 2, 8};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Проверка на равенство числу 5 (подсчет итоговой суммы): " + SumArray(arr, (item) -> item == 5));
        System.out.println("Сумма чисел, не находящихся в диапазоне от 4 до 8 равно: " + SumArray(arr, (item) -> item < 4 || item > 8));
        System.out.println("Сумма попожительных чисел равна: " + SumArray(arr, (item) -> item > 0));
        System.out.println("Сумма отрицательных чисел равна: " + SumArray(arr, (item) -> item < 0));
    }

    private static int SumArray(int[] arr, Predicate<Integer> predicate) {
        int sum = 0;
        for (int item : arr) {
            if (predicate.test(item)) {
                sum += item;
            }
        }
        return sum;
    }
}
