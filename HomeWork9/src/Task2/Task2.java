package Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static final int maxCountNumber = 1_000_000; //Максимальное число записанных числе в файл
    private static final File filePrimeNumbers = new File("primeNumber.txt"); //Файл для зранения простых чисел
    private static final File fileFactorialNumber = new File("factorialNumber.txt"); //Файл для хранения информации о факториале каждого числа
    private static long timeCompletionAddNumberInFile = 0; //Время завершения заполнения файла числами
    private static long timeCompletionCalcFactorialNumberAndWriteInFile = 0; //Время завершения подсчета файториала числа и записи в файл
    private static long timeCompletionFindPrimeNumberAndWriteInFile = 0; //Время завершения поиска простых чисел и записи из в файл

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к текстовому файлу: ");
        String filePath = scanner.next();
        File file = new File(filePath);
        if ((!file.exists()) || (!file.isFile())) {
            System.out.println("Ошибка. Файл не существует или выбранный Вами файл не является файлом как таковым не является!");
        } else {
            Thread threadFillFile = new Thread(() -> { //Поток заполнения файла числами
                System.out.println("Заполняю файл числами......");
                long before = System.currentTimeMillis();
                try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
                    for (int i = 0; i < maxCountNumber; i++) {
                        printWriter.println((int) (Math.random() * 20) + 1);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                long after = System.currentTimeMillis();
                System.out.println("Закончил заполнение файла числами файл числами......");
                timeCompletionAddNumberInFile = after - before;
            });

            Thread threadFindPrimeNumber = new Thread(() -> { //Поток поиска простых чисел из заполненного файла
                try (PrintWriter printWriter = new PrintWriter(filePrimeNumbers)) {
                    threadFillFile.join(); //Жду, пока первый поток завешит заполнение файла числами
                    System.out.println("Начинаю нахождение простых числел......");
                    long before = System.currentTimeMillis();
                    List<String> primeNumbers = Files.readAllLines(Paths.get(filePath))
                            .stream()
                            .filter(item -> isPrimeNumber(Long.parseLong(item)))
                            .distinct()
                            .toList();
                    for (String primeNumber : primeNumbers) { //Записываю в файл
                        printWriter.println(primeNumber);
                    }
                    long after = System.currentTimeMillis();
                    System.out.println("Закончил нахождение поиска простых чисел");
                    timeCompletionFindPrimeNumberAndWriteInFile = after - before;
                } catch (IOException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            Thread threadCalcFactorial = new Thread(() -> { //Поток поиска простых чисел из заполненного файла
                try (PrintWriter printWriter = new PrintWriter(fileFactorialNumber)) {
                    threadFillFile.join(); //Жду, пока первый поток завешит заполнение файла числами
                    System.out.println("Начинаю подсчет факториала каждого числа......");
                    long before = System.currentTimeMillis();
                    List<String> factorialInfo = Files.readAllLines(Paths.get(filePath))
                            .stream()
                            .map((item) -> "Факториал числа " + item + " равен " + factorial(Long.parseLong(item)))
                            .toList();
                    for (String info : factorialInfo) { //Записываю в файл
                        printWriter.println(info);
                    }
                    long after = System.currentTimeMillis();
                    System.out.println("Закончил подсчет факториала каждого числа.");
                    timeCompletionCalcFactorialNumberAndWriteInFile = after - before;
                } catch (IOException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            threadFillFile.start();
            threadFindPrimeNumber.start();
            threadCalcFactorial.start();
            try {
                threadFindPrimeNumber.join();
                threadCalcFactorial.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Статистика");
            System.out.println("Время завершения (в миллисекундах) операции заполнения файла числами равно: " + timeCompletionAddNumberInFile);
            System.out.println("Время завершения (в миллисекундах) операции поиска простых чисел из файла и добавление их в новый файл равно: " + timeCompletionFindPrimeNumberAndWriteInFile);
            System.out.println("Время завершения (в миллисекундах) операции подсчета факториала каждого числа и добавления результата в новый файл равно: " + timeCompletionCalcFactorialNumberAndWriteInFile);
        }
    }

    private static boolean isPrimeNumber(long number) { //Метод проверки, является ли число простым
        boolean isPrimeNumber = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return number == 1 || isPrimeNumber;
    }

    private static long factorial(long number) { //Метод подcчета факториала числа
        if (number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
