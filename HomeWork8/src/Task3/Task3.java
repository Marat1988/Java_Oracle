package Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пусть к первому файлу: ");
        String pathFile = scanner.next();
        List<String> listFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile, StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                listFromFile.add(line);
                line = bufferedReader.readLine();
            }
            List<Integer> listFirst = elementsFromString(listFromFile.get(0));
            List<Integer> listSecond = elementsFromString(listFromFile.get(1));
            System.out.println("===================================================");
            System.out.println("Первый массив: ");
            showInfoArray(listFirst);
            System.out.println("===================================================");
            System.out.println("Второй массив: ");
            showInfoArray(listSecond);
            System.out.println("===================================================");
            List<Integer> unionArray = Stream.of(listFirst,listSecond)
                    .flatMap(Collection::stream)
                    .toList();
            System.out.println("Объединенный массив: ");
            showInfoArray(unionArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Элементы из строки
    private static List<Integer> elementsFromString(String line){
        line = line.replaceAll("\\s+"," "); //Удаление лишних пробелов.
        return Arrays.stream(line.split(" "))
                .map((item)->Integer.parseInt(item.trim()))
                .toList();
    }
    //Отображение информации о массиве (Максимальный элемент, минимальный элемент, сумма элементов массива)
    private static void showInfoArray(List<Integer> array){
        System.out.println("Элементы массива");
        array.forEach(System.out::println);
        System.out.println("Сумма элементов массива равна: " + array.stream().reduce(Integer::sum).get());
        System.out.println("Максимальный элемент массива равен: " + Collections.max(array));
        System.out.println("Минимальный элемент массива равен: " + Collections.min(array));
    }
}
