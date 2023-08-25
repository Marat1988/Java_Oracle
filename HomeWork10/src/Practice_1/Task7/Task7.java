package Practice_1.Task7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> forbiddenMaps = new HashMap<>();
        System.out.print("Введите запрещенное слово для поиска или наждите стоп для выхода: ");
        String inputUser = scanner.next();
        while (!inputUser.equals("стоп")) {
            forbiddenMaps.put(inputUser, (long) 0);
            System.out.print("Введите запрещенное слово для поиска или наждите стоп для выхода: ");
            inputUser = scanner.next();

        }
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.next();
        File file = new File(filePath);
        try {
            List<String> correctedText = Files.readAllLines(file.toPath()).stream()
                    .map(line -> {
                        for (Map.Entry<String, Long> pair : forbiddenMaps.entrySet()) {
                            if (Arrays.stream(line.split(" "))
                                    .anyMatch(w -> w.contains(pair.getKey()))) {
                                long countAll = pair.getValue() + Arrays.stream(line.split(" "))
                                        .filter(w -> w.equals(pair.getKey()))
                                        .count();
                                forbiddenMaps.put(pair.getKey(), countAll);
                                line = line.replaceAll(pair.getKey(), "");
                            }
                        }
                        return line.trim();
                    })
                    .filter(item -> !item.isEmpty())
                    .toList();
            addLinesInFile(file, false, correctedText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Статиcтика замен: ");
        forbiddenMaps.forEach((s, aLong) -> System.out.println(s + " : " + aLong));
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
