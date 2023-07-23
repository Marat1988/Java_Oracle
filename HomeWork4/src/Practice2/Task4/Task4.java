package Practice2.Task4;


import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int evenSum = Arrays.stream(arr).filter(item -> item % 2 == 0).sum(); //Четные
        int notEvenSum = Arrays.stream(arr).filter(item -> item % 2 != 0).sum(); //Не четные
        int rangeNumberSum = Arrays.stream(arr).filter(item -> item >= 4 && item <= 7).sum(); //В диапазоне от 4 до 7
        int userParam = 5;
        int chooseUserParamNumberSum = Arrays.stream(arr).filter(item -> item % userParam == 0).sum(); //Проверка на кратность параметру

        System.out.println("Сумма четных элементов равна: " + evenSum);
        System.out.println("Сумма не четных элементов равна: " + notEvenSum);
        System.out.println("Сумма элементов, которые находятся в диапазоне от 4 до 7 включительно равно: " + rangeNumberSum);
        System.out.println("Сумма элементов, кратных " + userParam + " равно: " + chooseUserParamNumberSum);


    }


}
