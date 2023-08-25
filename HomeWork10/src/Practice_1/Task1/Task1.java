package Practice_1.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.next();
        File file = new File(path);
        try {
            Files.readAllLines(file.toPath())
                    .stream()
                    .map(line -> line.replaceAll("\\s+", " "))
                    .toList()
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
