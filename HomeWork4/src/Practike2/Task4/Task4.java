package Practike2.Task4;


import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum1 = Arrays.stream(arr).filter(item -> item % 2 == 0).sum(); //Четные
        int sum2 = Arrays.stream(arr).filter(item -> item % 2 != 0).sum(); //Не четные
        int sum3 = Arrays.stream(arr).filter(item -> item >= 4 && item <= 7).sum(); //В диапазоне от 4 до 7
        int userParam = 5;
        int sum4 = Arrays.stream(arr).filter(item -> item % userParam == 0).sum(); //Проверка на кратность параметру

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);


    }


}
