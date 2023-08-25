package Practice_1.Task6;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к первому файлу: ");
        String pathFile_1 = scanner.next();
        System.out.print("Введите путь к второму файлу: ");
        String pathFile_2 = scanner.next();
        System.out.print("Введите путь к третьему файлу: ");
        String pathFile_3 = scanner.next();
        System.out.print("Введите путь к результирующему файлу (куда будем все сохранять): ");
        String finalFilePath = scanner.next();
        List<File> files = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        files.add(new File(pathFile_1));
        files.add(new File(pathFile_2));
        files.add(new File(pathFile_3));
        File finalFile = new File(finalFilePath);

        for (File f : files) { //Побайтово считываем
            try (InputStream inputStream = new FileInputStream(f)) {
                byte[] array = new byte[8192];
                int countReadBytes = inputStream.read(array);
                while (countReadBytes > 0) {
                    result.append(new String(array, 0, countReadBytes));
                    countReadBytes = inputStream.read(array);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (OutputStream outputStream = new FileOutputStream(finalFile, true)) { //Побайтово записываем
            outputStream.write(result.toString().getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Количество байт: " + result.toString().getBytes().length);
    }

}
