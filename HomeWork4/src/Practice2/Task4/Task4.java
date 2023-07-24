package Practice2.Task4;


import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Сумма четных элементов равна: " + Calc(arr, (item) -> item % 2 == 0));
        System.out.println("Сумма не четных элементов равна: " + Calc(arr, (item) -> item % 2 != 0));
        System.out.println("Сумма элементов, которые находятся в диапазоне от 4 до 7 включительно равно: " + Calc(arr, (item) -> item >= 4 && item <= 7));
        int userParam = 5;
        System.out.println("Сумма элементов, кратных " + userParam + " равно: " + Calc(arr, (item) -> item % userParam == 0));
    }

    public static int Calc(int[] arr, Predicate predicate) {
        int sum = 0;
        for (int j : arr) {
            if (predicate.test(j)) {
                sum += j;
            }
        }
        return sum;
    }
}
