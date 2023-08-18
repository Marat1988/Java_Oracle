package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пусть к первому файлу: ");
        String pathFile = scanner.next();

        ArrayList<String> array = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile, StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                array.add(line);
                line = bufferedReader.readLine();
            }
            Optional<String> chooseLine = array.stream()
                    .max(Comparator.comparingInt(String::length));

            if (chooseLine.isPresent()) {
                String lineMax = chooseLine.get();
                System.out.println("Самая длиннас строка: " + lineMax);
                System.out.println("Размер самой длинной строки равен: " + lineMax.length());
            }

            chooseLine.ifPresent(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
