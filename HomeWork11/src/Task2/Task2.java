package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static final List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        products.add(new Product("Нежинская", CATEGORY_PRODUCT.milk, 48));
        products.add(new Product("Фермерское", CATEGORY_PRODUCT.milk, 50));
        products.add(new Product("Простоквашино", CATEGORY_PRODUCT.milk, 52));
        products.add(new Product("Бочу", CATEGORY_PRODUCT.bread, 48));
        products.add(new Product("Бочу", CATEGORY_PRODUCT.bread, 55));
        products.add(new Product("Галицкий", CATEGORY_PRODUCT.bread, 50));
        products.add(new Product("Литовский", CATEGORY_PRODUCT.bread, 52));
        products.add(new Product("Балтика", CATEGORY_PRODUCT.beer, 48));
        products.add(new Product("Баварское", CATEGORY_PRODUCT.beer, 50));
        products.add(new Product("Бритаиское", CATEGORY_PRODUCT.beer, 52));
        System.out.println("Введите:\n" +
                "1). Показать все продукты;\n" +
                "2). Показать все продукты с названием меньше 5 символов;\n" +
                "3). Посчитать сколько раз встречается продукт, чье название ввёл пользователь;\n" +
                "4). Показать все продукты, которые начинаются на заданную букву;\n" +
                "5). Показать все продукты из категории \"Молоко\";\n" +
                "6). Для выхода\n");

        int inputUser = scanner.nextInt();
        while (inputUser != 6) {
            switch (inputUser) {
                case 1 -> products.forEach(System.out::println);
                case 2 -> products.stream()
                        .filter(product -> product.getName().length() < 5)
                        .forEach(System.out::println);
                case 3 -> System.out.println(countProduct());
                case 4 -> startLetterProduct();
                case 5 -> products.stream()
                        .filter(product -> product.getCategoryProduct() == CATEGORY_PRODUCT.milk)
                        .forEach(System.out::println);
                default -> System.out.println("Не корректный ввод");
            }
            System.out.print("Введите следующий пункт меню или введите 6 для выхода: ");
            inputUser = scanner.nextInt();
        }
    }

    private static long countProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String nameProduct = scanner.next();
        return products.stream()
                .filter(product -> product.getName().equals(nameProduct))
                .count();
    }

    private static void startLetterProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите стартовую букву для поиска: ");
        String letter = scanner.next();
        products.stream()
                .filter(product -> product.getName().startsWith(letter))
                .forEach(System.out::println);
    }
}
