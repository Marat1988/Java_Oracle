package Practice_1.Task4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.next();
        int countLetters = 0;
        int countNumbers = 0;
        int countPunctuationMarks = 0;
        File file = new File(path);
        try {
            List<String> downloadText = Files.readAllLines(file.toPath())
                    .stream()
                    .map(line -> line.replaceAll("\\s+", " "))
                    .toList();

            for (String line : downloadText) {
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))){
                        countLetters++;
                    }
                    if (Character.isDigit(line.charAt(i))){
                        countNumbers++;
                    }

                    if ((line.charAt(i)=='.') || (line.charAt(i)==',')){
                        countPunctuationMarks++;
                    }
                }
            }
            System.out.println("Количество букв: " + countLetters);
            System.out.println("Количество цифр: " + countNumbers);
            System.out.println("Количество знаков препинания: " + countPunctuationMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
