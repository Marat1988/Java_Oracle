package Practice_2.Task4;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.next();
        File file = new File(path);
        System.out.print("Введите слово для поиска: ");
        String word = scanner.next();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            int countFindWord = 0;
            List<String> downloadText = Files.readAllLines(file.toPath())
                    .stream()
                    .toList();
            for (String item : downloadText) {
                countFindWord += (int) Arrays.stream(item.split(" "))
                        .filter(w -> w.equals(word))
                        .count();
            }
            return countFindWord;
        });
        executorService.shutdown();
        try {
            System.out.println("Количество слов " + word + " равно: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
