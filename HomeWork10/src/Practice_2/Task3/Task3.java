package Practice_2.Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static final File evenFile = new File("even.txt");
    private static final File oddFile = new File("odd.txt");
    private static int countEven = 0;
    private static int countOdd = 0;

    public static void main(String[] args) {
        try {
            evenFile.createNewFile();
            oddFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к текстовому файлу: ");
        String filePath = scanner.next();
        File file = new File(filePath);

        Thread threadEven = new Thread(() -> {
            try {
                List<String> downloadText = Files.readAllLines(file.toPath())
                        .stream()
                        .filter(item -> Integer.parseInt(item) % 2 == 0)
                        .toList();
                addLinesInFile(evenFile, false, downloadText);
                countEven = downloadText.size();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadOdd = new Thread(() -> {
            try {
                List<String> downloadText = Files.readAllLines(file.toPath())
                        .stream()
                        .filter(item -> Integer.parseInt(item) % 2 != 0)
                        .toList();
                addLinesInFile(oddFile, false, downloadText);
                countOdd = downloadText.size();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        threadEven.start();
        threadOdd.start();
        try {
            threadEven.join();
            threadOdd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Количество четных чисел: " + countEven);
        System.out.println("Количество не четных чисел: " + countOdd);
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
