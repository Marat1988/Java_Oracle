package Practice_1.Task3;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.next();
        System.out.print("Введите слово для поиска: ");
        String word = scanner.next();
        int count = 0;
        File file = new File(path);
        try {
            List<String> downloadText = Files.readAllLines(file.toPath())
                    .stream()
                    .map(line -> line.replaceAll("\\s+", " "))
                    .toList();

            for (String line : downloadText) {
                count += (int) Arrays.stream(line.split(" "))
                        .filter(findWord -> findWord.equals(word))
                        .count();
            }
            System.out.println("Слово: " + word + " встречается в файле: " + file.getAbsolutePath() + " " + count + " раз.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
