package Task4;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    private static final List<Projector> projectors = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        projectors.add(new Projector("Lingbo T4max", 2023, 150000, "Китай"));
        projectors.add(new Projector("Akenori LED-888P", 2020, 125000, "Япония"));
        projectors.add(new Projector("Wanbo Projector X1 PRO", 2019, 80666, "США"));
        projectors.add(new Projector("Sony VPL-VW325ES", 2020, 124000, "Канада"));
        projectors.add(new Projector("BenQ W1800", 2020, 45000, "Япония"));

        System.out.println("Введите:\n" +
                "1). Показать все проекторы;\n" +
                "2). Показать все проекторы одного производителя;\n" +
                "3). Показать все проекторы текущего года;\n" +
                "4). Показать все проекторы дороже заданной цены;\n" +
                "5). Показать все проекторы, отсортированные по цене по возрастанию;\n" +
                "6). Показать все проекторы, отсортированные по цене по убыванию;\n" +
                "7). Показать все проекторы, отсортированные по году выпуска по возрастанию;\n" +
                "8). Показать все проекторы, отсортированные по году выпуска по убыванию;\n" +
                "9). Для выхода\n");

        int inputUser = scanner.nextInt();
        while (inputUser != 9) {
            switch (inputUser) {
                case 1 -> projectors.forEach(System.out::println);
                case 2 -> showInfoManufacturer();
                case 3 -> projectors.stream()
                        .filter(item -> item.getYearRelease() == Year.now().getValue())
                        .forEach(System.out::println);
                case 4 -> showInfoPrice();
                case 5 -> projectors.stream()
                        .sorted((o1, o2) ->
                        {
                            if (o1.getPrice() > o2.getPrice()) {
                                return 1;
                            } else {
                                if (o1.getPrice() < o2.getPrice()) {
                                    return -1;
                                }
                            }
                            return 0;
                        })
                        .forEach(System.out::println);
                case 6 -> projectors.stream()
                        .sorted((o1, o2) -> {
                            if (o1.getPrice() < o2.getPrice()) {
                                return 1;
                            } else {
                                if (o1.getPrice() > o2.getPrice()) {
                                    return -1;
                                }
                            }
                            return 0;
                        })
                        .forEach(System.out::println);
                case 7 -> projectors.stream()
                        .sorted(((o1, o2) -> (o1.getYearRelease() - o2.getYearRelease())))
                        .forEach(System.out::println);
                case 8 -> projectors.stream()
                        .sorted(((o2, o1) -> (o1.getYearRelease() - o2.getYearRelease())))
                        .forEach(System.out::println);
                default -> System.out.println("Не корректный ввод");
            }
            System.out.print("Введите следующий пункт меню или введите 7 для выхода: ");
            inputUser = scanner.nextInt();
        }
    }

    private static void showInfoManufacturer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите страну производителя: ");
        String manufacturer = scanner.next();
        projectors.stream()
                .filter(item -> item.getManufacturer().equals(manufacturer))
                .forEach(System.out::println);
    }

    private static void showInfoPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену для поиска дороже заданной цены: ");
        double price = scanner.nextDouble();
        projectors.stream()
                .filter(item -> item.getPrice() > price)
                .forEach(System.out::println);
    }
}
