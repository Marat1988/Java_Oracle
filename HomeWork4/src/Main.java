import Task1.Builder;
import Task1.Human;
import Task1.Pilot;
import Task1.Sailor;
import Task2.Animal;
import Task2.Crocodile;
import Task2.Kangaroo;
import Task2.Tiger;
import Task3.Money;
import Task3.Product;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human[] humans = {
                new Builder(30, "Иванов И.И.", "Плотник"),
                new Sailor(20, "Петров П.П.", 100),
                new Pilot(40, "Сидоров С.С.", 1000)
        };
        Arrays.stream(humans).forEach(System.out::println);
        System.out.println("======================================================================");
        Animal[] animals = {
                new Crocodile("Гена", "Пресмыкающиеся", 5),
                new Kangaroo("Степан", "Млекопитающие", 70),
                new Tiger("Тигрюля", "Кошачьих", 60)
        };
        Arrays.stream(animals).forEach(System.out::println);
        System.out.println("======================================================================");
        try {
            Product product = new Product("Мышь компьютерная", new Money(1450, 34));
            System.out.println(product);
            product.reducePrice(20,57);
            System.out.println(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("======================================================================");

    }
}