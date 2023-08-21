package Task4;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;

public class Task4 {
    private static final File finalFile = new File("finalFile.txt"); //Итоговый файл, куда буду вставлять текст из других файлов
    private static final File listWords = new File("listWords.txt"); //Файл со списоком запрещенных слов
    private static int countFiles = 0; //Количество найденных файлов с искомым словом
    private static long executionTimeFindFile = 0; //Время выполнения поиска нужных файлов (первый поток) в миллисекундах и добавление содержимого в финальный файл
    private static long executionTimeProcessingFile = 0; //Время обработки финального файла (второй поток) в миллисекундах

    public static void main(String[] args) {
        createFiles();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пусть к существующей папке: ");
        String filePath = scanner.next();
        File directory = new File(filePath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Ошибка. Не является папкой или папка не существует");
        } else {
            System.out.print("Введите слово для поиска: ");
            String searchWord = scanner.next();
            File[] files = directory.listFiles(File::isFile);
            if (files != null) {
                Thread threadFindFilesAndFillFinalFile = new Thread(() -> {
                    long before = System.currentTimeMillis();
                    System.out.println("Начинаю поиск нужных файлов по критерию.....");
                    for (File f : files) {
                        try {
                            List<String> downloadText = Files.readAllLines(f.toPath())
                                    .stream()
                                    .map(line -> line.replaceAll("\\s+", " "))
                                    .toList();
                            for (String line : downloadText) {
                                if (Arrays.asList(line.split(" ")).contains(searchWord)) {
                                    countFiles++;
                                    addLinesInFile(finalFile, true, downloadText); //Если слово найдено, то добавляю (сливаю) содержимое файла в финальный файл
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Закончил поиск нужных файлов");
                    long after = System.currentTimeMillis();
                    executionTimeFindFile = after - before;
                });

                Thread threadExecutionProcessingFile = new Thread(() -> {
                    try {
                        threadFindFilesAndFillFinalFile.join(); //Ожидаю, пока завершится первый поток
                        long before = System.currentTimeMillis();
                        System.out.println("Начинаю вырезать запрещенные слова из файла.....");
                        List<String> correctedText = Files.readAllLines(finalFile.toPath()).stream()
                                .map(line -> {
                                    try {
                                        List<String> forbiddenWords = Files.readAllLines(listWords.toPath())
                                                .stream()
                                                .distinct()
                                                .toList();
                                        for (String word : forbiddenWords) {
                                            if (Arrays.stream(line.split(" "))
                                                    .anyMatch(w -> w.contains(word))) {
                                                line = line.replaceAll(word, "");
                                            }
                                        }
                                    } catch (IOException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    return line.trim();
                                })
                                .filter(item -> !item.isEmpty())
                                .toList();
                        addLinesInFile(finalFile, false, correctedText);
                        System.out.println("Закончил вырезать запрещенные слова из файла.");
                        long after = System.currentTimeMillis();
                        executionTimeProcessingFile = after - before;
                    } catch (InterruptedException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
                threadFindFilesAndFillFinalFile.start();
                threadExecutionProcessingFile.start();
                try {
                    threadExecutionProcessingFile.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Стастика: ");
                System.out.println("================================================================================");
                System.out.println("Количество найденных файлов с введенным Вами словом: " + countFiles);
                System.out.println("Время (в миллисекундах) затраченное на поиск слова в файлах и добавление содержимого в финальный файл равно: " + executionTimeFindFile);
                System.out.println("Время (в миллисекундах) затраченное на обработку (вырезание списка запрещенных слов) финального файла: " + executionTimeProcessingFile);
                System.out.println("================================================================================");
            } else {
                System.out.println("В введенной Вами директории файлов не найдено");
            }
        }
    }

    private static void createFiles() { //Создание необходимых начальных файлов
        try {
            if (finalFile.exists()) {
                finalFile.delete(); //Удаляю файл. Чтобы текст не перезаписывался
            }
            finalFile.createNewFile();
            listWords.createNewFile();
            if (listWords.length() == 0) {
                addLinesInFile(listWords, true, new ArrayList<>(List.of(new String[]{"клавиатура", "ручка", "монитор", "телефон", "автомобиль"}))); //По-умолчанию. Список запрещенных слов
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
