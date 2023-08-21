package Task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class Task3 {
    private static int copyCountFolder = 0; //Общее количество скопированных папок
    private static int copyCountFile = 0; //Общее количество скопированных файлов
    private static long executionTime = 0; //Время выполнения операции копирования папок в миллисекундах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к существующей директории: ");
        String source = scanner.next();
        File sourceFolder = new File(source);
        if ((!sourceFolder.isDirectory()) || (!sourceFolder.exists())) {
            System.out.println("Ошибка. Не является папкой или не папка не существует");
        } else {
            System.out.print("Введите существующий путь, куда вы хотите скопировать папку: ");
            String destination = scanner.next();
            File destinationFolder = new File(destination);
            if ((!destinationFolder.isDirectory()) || (!destinationFolder.exists())) {
                System.out.println("Ошибка. Не является папкой или папка не существует");
            } else {
                Thread threadCopyFolder = new Thread(() -> {
                    System.out.println("Начинаю операцию копирования папки....");
                    long before = System.currentTimeMillis();
                    try {
                        CopyFolder(sourceFolder, destinationFolder);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Закончил операцию копирования папки");
                    long after = System.currentTimeMillis();
                    executionTime = after - before;
                });
                threadCopyFolder.start();
                try {
                    threadCopyFolder.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Статистика");
                System.out.println("=================================================================================");
                System.out.println("Общее количество скопированных файлов равно: " + copyCountFile);
                System.out.println("Общее количество скопированных папок: " + copyCountFolder);
                System.out.println("Время (в миллисекундах), затраченное на выполнение операции равно: " + executionTime);
                System.out.println("=================================================================================");
            }
        }
    }

    private static void CopyFolder(File sourceFolder, File destinationFolder) throws IOException {
        File[] files = sourceFolder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    Files.copy(f.toPath(), new File(destinationFolder.getAbsolutePath(), f.getName()).toPath()); //Копирование папок
                    copyCountFolder++;
                    CopyFolder(f, new File(destinationFolder.getAbsolutePath(), f.getName()));
                } else {
                    Files.copy(f.toPath(), (new File(destinationFolder, f.getName()).toPath()), StandardCopyOption.REPLACE_EXISTING); //Копирование файла
                    copyCountFile++;
                }
            }
        }
    }
}
