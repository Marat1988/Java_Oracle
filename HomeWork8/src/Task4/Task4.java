package Task4;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к текстовому файлу: ");
        String pathTextFile = scanner.next();
        List<Integer> userArray = new ArrayList<>();
        System.out.println("Введите элементны массива или введите stop для выхода");
        String inputUser = scanner.next();
        while (!inputUser.equals("stop")) {
            userArray.add(Integer.parseInt(inputUser));
            inputUser = scanner.next();
        }

        List<Integer> even = selectItemInArray(userArray, item -> item % 2 == 0);
        List<Integer> odd = selectItemInArray(userArray, item -> item % 2 != 0);
        try (PrintStream out = new PrintStream(new FileOutputStream(pathTextFile, true))) {
            out.println(userArray); //Сохраняем исходныем элементы
            out.println(even.toString()); //Сохраняем четные элементы
            out.println(odd.toString()); //Сохраняем не четные элементы
            Collections.reverse(userArray); //Переворачиваем массив
            out.println(userArray); //Сохраняем перевернутый массив
            System.out.println("Данные записаны в файл");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static List<Integer> selectItemInArray(List<Integer> arr, Predicate<Integer> predicate) {
        return arr.stream()
                .filter(predicate)
                .toList();
    }
}
