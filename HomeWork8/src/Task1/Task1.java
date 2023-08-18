package Task1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пусть к первому файлу: ");
        String pathFile1 = scanner.next();
        System.out.print("Введите пусть ко второму файлу: ");
        String pathFile2 = scanner.next();
        String[] firstArray = readLineFromFile(pathFile1);
        String[] secondArray = readLineFromFile(pathFile2);

        System.out.println("Не совпададающие строки из первого файла: ");
        printNoneMatchLines(firstArray, secondArray);

        System.out.println("Не совпададающие строки из второго файла: ");
        printNoneMatchLines(secondArray, firstArray);

    }

    //Построчное чтение из файла. В результате получаем массив строк
    private static String[] readLineFromFile(String pathFile) {
        ArrayList<String> array = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile, StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                array.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array.toArray(new String[]{});
    }

    //Печать не совпадающих строк
    private static void printNoneMatchLines(String[] firstArray, String[] secondArray) {
        Arrays.stream(firstArray)
                .filter(item -> Arrays.stream(secondArray).noneMatch(item::equals))
                .distinct()
                .forEach(System.out::println);
    }
}
