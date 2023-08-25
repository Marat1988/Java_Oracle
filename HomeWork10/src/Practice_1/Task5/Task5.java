package Practice_1.Task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    private static long countReplace = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.next();
        System.out.print("Введите слово для поиска: ");
        String word = scanner.next();
        System.out.print("Введите слово для замены: ");
        String replaceWord = scanner.next();
        File file = new File(path);
        try {
            List<String> correctedText = Files.readAllLines(file.toPath()).stream()
                    .map(line -> {
                        if (Arrays.stream(line.split(" "))
                                .anyMatch(w -> w.contains(word))) {
                            countReplace += (int) Arrays.stream(line.split(" "))
                                    .filter(w -> w.equals(word))
                                    .count();
                            line = line.replaceAll(word, replaceWord);
                        }
                        return line.trim();
                    })
                    .filter(line -> !line.isEmpty())
                    .toList();
            addLinesInFile(file, false, correctedText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Количество замен: " + countReplace);
    }

    private static void addLinesInFile(File file, boolean append, List<String> text) { //Заполнение файла текстом
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, append))) {
            for (String item : text) {
                printWriter.println(item);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
